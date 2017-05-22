package Schwarm;

import Vektor.LineareAlgebra;
import Vektor.Vektor3D;

import java.util.ArrayList;

/**
 * Created by Ezydenias on 5/9/2017. dsfdssgfcmjkm,mfdfd
 */
public class Bird extends Aktor {

    private boolean isAlive;        //die from everything
    protected Vektor3D tempvelocity;
    private double sepDistance;
    private double alignDistance;
    private double cohDistance;
    public Vektor3D fiedlsizemax;
    public Vektor3D fiedlsizemin;

    public Bird(Vektor3D velocity, Vektor3D position) {
        super(velocity, position);
        this.isAlive = true;
        this.tempvelocity = new Vektor3D();
        this.sepDistance = 100;
        this.alignDistance = 125;
        this.cohDistance = 150;
        this.fiedlsizemax = new Vektor3D(1000, 1000, 0);
        this.fiedlsizemin = new Vektor3D(-1000, -1000, -1000);
    }

    public void act(ArrayList<Aktor> stuff) {
        for (int i = 0; i < 2; i++)
            update();
        this.tempvelocity.setPosition(0, 0, 0);
        flock(stuff);
    }

    private void flock(ArrayList<Aktor> stuff) {
        Vektor3D sep = new Vektor3D(separate(stuff));   // Separation
        Vektor3D ali = new Vektor3D(align(stuff));      // Alignment
        Vektor3D coh = new Vektor3D(cohesion(stuff));   // Cohesion
        // Arbitrarily weight these forces
        try {
            sep.mult(3);
            ali.mult(1.0);
            coh.mult(1.0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add the force vectors to acceleration
        tempvelocity.setPosition(0, 0, 0);
        try {
            tempvelocity.add(sep);
            tempvelocity.add(ali);
            tempvelocity.add(coh);



        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void act() {
        if (isAlive != true) {
            return;
        }

    }

    public void reAnimate() {
        if (isAlive != true) {
            isAlive = true;
            //set new position here
        }
    }

    private void update() {

        try {
            System.out.print("tempvelocity" + tempvelocity.x + " " + tempvelocity.y + " " + tempvelocity.z);
            tempvelocity.div(5);
            velocity.add(tempvelocity);

            if(this.position.z>300){
                this.velocity.z=0;
            } else if (this.position.z<20){
                this.velocity.z=0;
            }

            if(this.position.z>180){
                this.velocity.z-=(0.000001*this.position.z);
            }else if (this.position.z<80){
                this.velocity.z+=(0.002/this.position.z);
            }

            velocity.x = velocity.x / (Math.abs(velocity.x) + Math.abs(velocity.y) + Math.abs(velocity.z));
            velocity.y = velocity.y / (Math.abs(velocity.x) + Math.abs(velocity.y) + Math.abs(velocity.z));
            velocity.z = velocity.z / (Math.abs(velocity.x) + Math.abs(velocity.y) + Math.abs(velocity.z));


            this.position.add(velocity);
            System.out.print(number);

            LineareAlgebra.show(this.getPosition());

            borders();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void borders() {
        if (position.x < this.fiedlsizemin.x) position.x = this.fiedlsizemax.x;
        if (position.y < this.fiedlsizemin.y) position.y = this.fiedlsizemax.y;

        if (position.x > this.fiedlsizemax.x) position.x = this.fiedlsizemin.x;
        if (position.y > this.fiedlsizemax.y) position.y = this.fiedlsizemin.y;

    }

    // Method checks for nearby stuff and steers away
    Vektor3D separate(ArrayList<Aktor> stuff) {
        Vektor3D steer = new Vektor3D();
        double x = 1, y = 1, z = 1;
        double closest = Double.MAX_VALUE;
        int count = 0;

        Vektor3D tempInLine = new Vektor3D();
        try {
            for (Aktor other : stuff) {

                double distance = LineareAlgebra.euklDistance(other.getPosition(), this.getPosition());
                if (other != this) {
                    if (distance < sepDistance) {
                        count++;


                        tempInLine = LineareAlgebra.sub(other.getPosition(), this.getPosition());
                        tempInLine.x = Math.round(tempInLine.x);
                        tempInLine.y = Math.round(tempInLine.y);
                        tempInLine.z = Math.round(tempInLine.z);
                        if ((x = Math.round(this.velocity.x)) == 0)
                            x = 1;
                        if ((y = Math.round(this.velocity.y)) == 0)
                            y = 1;
                        if ((z = Math.round(this.velocity.z)) == 0)
                            z = 1;
                        tempInLine.div(x, y, z);

                        distance = 0.02 / distance;
                        if (distance < sepDistance/5)distance*=5;

                        if (tempInLine.x > this.position.x) {
                            steer.add(-distance, 0, 0);
                            //this.velocity.normalize();
                        } else if (tempInLine.x < this.position.x) {
                            steer.add(distance, 0, 0);
                            //this.velocity.normalize();
                        }

                        if (tempInLine.y > this.position.y) {
                            steer.add(0, -distance, 0);
                            //this.velocity.normalize();
                        } else if (tempInLine.y < this.position.y) {
                            steer.add(0, distance, 0);
                            //this.velocity.normalize();
                        }

                        if (tempInLine.z > this.position.z) {
                            steer.add(0, 0, -distance);
                            //this.velocity.normalize();
                        } else if (tempInLine.z < this.position.z) {
                            steer.add(0, 0, distance);
                            //this.velocity.normalize();
                        }


                    }
                    //keep track of how many
                }
            }


        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        if (count > 1) {
            try {
                steer.div(count);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return steer;
    }

    // Alignment
    // For every nearby Aktor in the system, calculate the average velocity
    Vektor3D align(ArrayList<Aktor> stuff) {
        Vektor3D steer = new Vektor3D();
        double x = 1, y = 1, z = 1;
        double closest = Double.MAX_VALUE;
        int count = 0;

        Vektor3D tempInLine = new Vektor3D();
        try {
            for (Aktor other : stuff) {
                double distance = LineareAlgebra.euklDistance(other.getPosition(), this.getPosition());
                if (other != this) {
                    if (getClass() == Bird.class) {
                        if (distance > sepDistance && distance < cohDistance) {
                            count++;
                            tempInLine = LineareAlgebra.sub(other.getPosition(), this.getPosition());
                            tempInLine.x = Math.round(tempInLine.x);
                            tempInLine.y = Math.round(tempInLine.y);
                            tempInLine.z = Math.round(tempInLine.z);
                            if ((x = Math.round(this.velocity.x)) == 0)
                                x = 1;
                            if ((y = Math.round(this.velocity.y)) == 0)
                                y = 1;
                            if ((z = Math.round(this.velocity.z)) == 0)
                                z = 1;
                            tempInLine.div(x, y, z);
                            distance = 0.02 / distance;
                            if (tempInLine.x != tempInLine.y || tempInLine.z != tempInLine.y || tempInLine.z != tempInLine.x) {
                                if (tempInLine.x > this.position.x) {
                                    steer.add(distance, 0, 0);
                                    //this.velocity.normalize();
                                } else if (tempInLine.x < this.position.x) {
                                    steer.add(-distance, 0, 0);
                                    //this.velocity.normalize();
                                }

                                if (tempInLine.y > this.position.y) {
                                    steer.add(0, distance, 0);
                                    //this.velocity.normalize();
                                } else if (tempInLine.y < this.position.y) {
                                    steer.add(0, -distance, 0);
                                    //this.velocity.normalize();
                                }

                                if (tempInLine.z > this.position.z) {
                                    steer.add(0, 0, distance);
                                    //this.velocity.normalize();
                                } else if (tempInLine.z < this.position.z) {
                                    steer.add(0, 0, -distance);
                                    //this.velocity.normalize();
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        if (count > 1) {
            try {
                steer.div(count);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return steer;
    }

    // Cohesion
    // For the average position (i.e. center) of all nearby stuff, calculate steering vector towards that position
    Vektor3D cohesion(ArrayList<Aktor> stuff) {
        Vektor3D steer = new Vektor3D();
        double x = 1, y = 1, z = 1;
        double closest = Double.MAX_VALUE;
        int count = 0;

        Vektor3D tempInLine = new Vektor3D();
        try {
            for (Aktor other : stuff) {
                double distance = LineareAlgebra.euklDistance(other.getPosition(), this.getPosition());
                if (other != this) {
                    if (getClass() == Bird.class) {
                        if (distance > sepDistance && distance < alignDistance) {
                            steer.add(other.getVelocity());


                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        if (count > 1) {
            try {
                steer.div(count);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return steer;

    }

    public double getSepDistance() {
        return sepDistance;
    }

    public void setSepDistance(double sepDistance) {
        this.sepDistance = sepDistance;
    }

    public double getAlignDistance() {
        return alignDistance;
    }

    public void setAlignDistance(double alignDistance) {
        this.alignDistance = alignDistance;
    }

    public double getCohDistance() {
        return cohDistance;
    }

    public void setCohDistance(double cohDistance) {
        this.cohDistance = cohDistance;
    }
}
