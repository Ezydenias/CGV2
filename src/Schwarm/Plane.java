package Schwarm;

import Vektor.LineareAlgebra;
import Vektor.Vektor3D;

import java.util.ArrayList;

/**
 * Created by Ezydenias on 5/9/2017.
 */


public class Plane extends ManMadeObjects{

    private Projectile one;         //cann have two Missles
    private Projectile two;         //planes try to kill each other
    protected Vektor3D tempvelocity;

    public boolean isdodging;
    public boolean isevading;
    public double effectiverange;
    public double evadingrange;
    public Vektor3D fiedlsizemax;
    public Vektor3D fiedlsizemin;


    private boolean isAlive;

    public Plane(Vektor3D velocity, Vektor3D position) {
        super(velocity, position);
        this.tempvelocity = new Vektor3D();
        this.isdodging=false;
        this.isevading=false;
        this.isAlive=true;
        this.fiedlsizemax = new Vektor3D(500, 500, 1000);
        this.fiedlsizemin = new Vektor3D(-500, -500, -500);
        effectiverange=200;
        evadingrange=50;
    }




    public void act(ArrayList<Aktor> stuff) {
        for (int i=0;i<5;i++)
        update();
           this.tempvelocity.setPosition(0, 0, 0);
           flock(stuff);


    }

    private void update() {

        try {
            System.out.print("tempvelocity"+tempvelocity.x+" "+tempvelocity.y+" "+tempvelocity.z);
            velocity.add(tempvelocity);

            this.position.add(velocity);
            System.out.print(number);

            if (this.position.z > 500) {
                this.velocity.z = 0;
            } else if (this.position.z < 10) {
                this.velocity.z = 0;
            }

            if (this.position.z > 400) {
                this.velocity.z -= (0.000001 * this.position.z);
            } else if (this.position.z < 20) {
                this.velocity.z += (0.002 / this.position.z);
            }

//            velocity.x=velocity.x/(Math.abs(velocity.x)+Math.abs(velocity.y)+Math.abs(velocity.z));
//            velocity.y=velocity.y/(Math.abs(velocity.x)+Math.abs(velocity.y)+Math.abs(velocity.z));
//            velocity.z=velocity.z/(Math.abs(velocity.x)+Math.abs(velocity.y)+Math.abs(velocity.z));

            velocity.normalize();

            this.isdodging=false;
            this.isevading=false;

            LineareAlgebra.show(this.getPosition());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void flock(ArrayList<Aktor> stuff)  {
        double x=1, y=1, z=1;
        double closest=Double.MAX_VALUE;

        Vektor3D tempInLine = new Vektor3D();
        try {
            for (Aktor enemy : stuff) {
                if (getClass() == Plane.class) {
                    if (enemy != this) {

                        double tempclosest = LineareAlgebra.euklDistance(enemy.getPosition(), this.getPosition());
                        // Vektor3D location = new Vektor3D(enemy.getPosition());
                        //Vektor3D velocity = new Vektor3D(enemy.getVelocity());

                        if (tempclosest < effectiverange) {
                            tempInLine.x = Math.round(tempInLine.x);
                            tempInLine.y = Math.round(tempInLine.y);
                            tempInLine.z = Math.round(tempInLine.z);

                            if ((x = Math.round(enemy.velocity.x)) == 0)
                                x = 1;
                            if ((y = Math.round(enemy.velocity.y)) == 0)
                                y = 1;
                            if ((z = Math.round(enemy.velocity.z)) == 0)
                                z = 1;
                            tempInLine.div(x, y, z);
                            if (tempInLine.x == tempInLine.y && tempInLine.y == tempInLine.z) {
                                this.tempvelocity.setPosition(0,0,0);
                                this.tempvelocity.setPosition((Math.random() * 0.002), (Math.random() * 0.002), (Math.random() * 0.002));
                                isdodging = true;

                            }
                        }

                        if ((tempclosest < evadingrange) && (isdodging == false)) {
                            if (closest > tempclosest) {
                                isevading = true;

                                closest = tempclosest;

                                tempInLine = LineareAlgebra.sub(enemy.getPosition(), this.getPosition());
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

                                this.tempvelocity.setPosition(0,0,0);

                                if (tempInLine.x > this.position.x) {
                                    this.tempvelocity.add(-0.002, 0, 0);
                                    //this.velocity.normalize();
                                } else if (tempInLine.x < this.position.x) {
                                    this.tempvelocity.add(0.002, 0, 0);
                                    //this.velocity.normalize();
                                }

                                if (tempInLine.y > this.position.y) {
                                    this.tempvelocity.add(0, -0.002, 0);
                                    //this.velocity.normalize();
                                } else if (tempInLine.y < this.position.y) {
                                    this.tempvelocity.add(0, 0.002, 0);
                                    //this.velocity.normalize();
                                }

                                if (tempInLine.z > this.position.z) {
                                    this.tempvelocity.add(0, 0, -0.002);
                                    //this.velocity.normalize();
                                } else if (tempInLine.z < this.position.z) {
                                    this.tempvelocity.add(0, 0, 0.002);
                                    //this.velocity.normalize();
                                }


                            }
                        }

                        if ((isdodging == false) && (isevading == false)) {
                            if (closest > tempclosest) {
                                closest = tempclosest;

                                tempInLine = LineareAlgebra.sub(enemy.getPosition(), this.getPosition());
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
                                if (tempInLine.x != tempInLine.y || tempInLine.z != tempInLine.y || tempInLine.z != tempInLine.x) {
                                    if (tempInLine.x > this.position.x) {
                                        this.tempvelocity.add(0.001, 0, 0);
                                        //this.velocity.normalize();
                                    } else if (tempInLine.x < this.position.x) {
                                        this.tempvelocity.add(-0.001, 0, 0);
                                        //this.velocity.normalize();
                                    }

                                    if (tempInLine.y > this.position.y) {
                                        this.tempvelocity.add(0, 0.001, 0);
                                        //this.velocity.normalize();
                                    } else if (tempInLine.y < this.position.y) {
                                        this.tempvelocity.add(0, -0.001, 0);
                                        //this.velocity.normalize();
                                    }

                                    if (tempInLine.z > this.position.z) {
                                        this.tempvelocity.add(0, 0, 0.001);
                                        //this.velocity.normalize();
                                    } else if (tempInLine.z < this.position.z) {
                                        this.tempvelocity.add(0, 0, -0.001);
                                        //this.velocity.normalize();
                                    }
                                }

                            }
                        }


                    }
                }

            }
        } catch (Exception e){
            System.out.println("some problemo");
        }
    }

    void borders() {
        if (position.x < this.fiedlsizemin.x) position.x = this.fiedlsizemax.x;
        if (position.y < this.fiedlsizemin.y) position.y = this.fiedlsizemax.y;

        if (position.x > this.fiedlsizemax.x) position.x = this.fiedlsizemin.x;
        if (position.y > this.fiedlsizemax.y) position.y = this.fiedlsizemin.y;

    }


    public void reAnimate(){
        if(isAlive!=true){
            isAlive=true;
            //set new position here
        }
    }
}
