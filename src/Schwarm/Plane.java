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


    private boolean isAlive;

    public Plane(Vektor3D velocity, Vektor3D position) {
        super(velocity, position);
        this.isAlive=true;
    }




    public void act(ArrayList<Aktor> stuff) {
        update();
        flock(stuff);


    }

    private void update() {

        try {
            velocity.x=velocity.x%10;
            velocity.y=velocity.y%10;
            velocity.z=velocity.z%10;
            this.position.add(velocity);
            System.out.print(number);
            LineareAlgebra.show(this.getPosition());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void flock(ArrayList<Aktor> stuff){
        double x=1, y=1, z=1;
        for (Aktor enemy : stuff){
            if(getClass()==Plane.class) {
                if (enemy != this) {
                    Vektor3D location = new Vektor3D(enemy.getPosition());
                    Vektor3D velocity = new Vektor3D(enemy.getVelocity());
                    try {
                        Vektor3D tempInLine = new Vektor3D(LineareAlgebra.sub(this.getPosition(), enemy.getPosition()));

                        if(LineareAlgebra.euklDistance(this.getPosition(),enemy.getPosition())<200){

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

                                if (tempInLine.x > this.position.x) {
                                    this.velocity.add(-0.2, 0, 0);
                                    //this.velocity.normalize();
                                } else if (tempInLine.x < this.position.x) {
                                    this.velocity.add(0.2, 0, 0);
                                    //this.velocity.normalize();
                                }

                                if (tempInLine.y > this.position.y) {
                                    this.velocity.add(0, -0.2, 0);
                                    //this.velocity.normalize();
                                } else if (tempInLine.y < this.position.y) {
                                    this.velocity.add(0, 0.2, 0);
                                    //this.velocity.normalize();
                                }

                                if (tempInLine.z > this.position.z) {
                                    this.velocity.add(0, 0, -0.2);
                                    //this.velocity.normalize();
                                } else if (tempInLine.z < this.position.z) {
                                    this.velocity.add(0, 0, 0.2);
                                    //this.velocity.normalize();
                                }



                        }else {

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
                                this.velocity.add((Math.random() * 0.2), (Math.random() * 0.2), (Math.random() * 0.2));
                                //this.velocity.normalize();
                            } else {
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
                                        this.velocity.add(0.1, 0, 0);
                                        //this.velocity.normalize();
                                    } else if (tempInLine.x < this.position.x) {
                                        this.velocity.add(-0.1, 0, 0);
                                        //this.velocity.normalize();
                                    }

                                    if (tempInLine.y > this.position.y) {
                                        this.velocity.add(0, 0.1, 0);
                                        //this.velocity.normalize();
                                    } else if (tempInLine.y < this.position.y) {
                                        this.velocity.add(0, -0.1, 0);
                                        //this.velocity.normalize();
                                    }

                                    if (tempInLine.z > this.position.z) {
                                        this.velocity.add(0, 0, 0.1);
                                        //this.velocity.normalize();
                                    } else if (tempInLine.z < this.position.z) {
                                        this.velocity.add(0, 0, -0.1);
                                        //this.velocity.normalize();
                                    }
                                }

                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }

        }
    }


    public void reAnimate(){
        if(isAlive!=true){
            isAlive=true;
            //set new position here
        }
    }
}
