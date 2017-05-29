#version 400 core

in vec3 otherPosition;
in vec3 otherVelocity;
in vec3 ownPosition;
in vec3 ownVelocity;

out vec3 out_Steer;

uniform float cohDistance;
uniform float sepDistance;
uniform float aliDistance;

void main(void){
        vec3 newVelocity = vec3(0.0,0.0,0.0);
        vec3 sepVec = vec3(0.0,0.0,0.0);
        vec3 aliVec = vec3(0.0,0.0,0.0);
        vec3 cohVec = vec3(0.0,0.0,0.0);
        vec3 inLine = InLineFunction(OwnVelocity, otherPosition, ownPosition);

        float distance = distance(otherPosition, ownPosition);


        if(distance < sepDistance)
            sepVec = Seperation(inLine, ownPosition, distance, sepDistance);
        if(distance > sepDistance && distance < cohDistance){
            aliVec = Align(inLine, ownPosition, distance);
            cohVec = Cohestion(otherVelocity);
        }
        if(distance < sepDistance/5)
            sepVec = sepVec*3.0f;



        sepVec = sepVec*3.0f;
        //aliVec = mult(aliVec,1);
        //cohVec = mult(cohVec,1);

        newVelocity=add(newVelocity,sepVec);
        newVelocity=add(newVelocity,aliVec);
        newVelocity=add(newVelocity,cohVec);

        out_Steer=newVelocity;
    }

vec3 InLineFunction(vec3 OwnVelocity, vec3 otherPosition, vec3 ownPosition){
        vec3 tempOwnVelocity=ownVelocity;
        vec3 inLine = otherPosition - ownPosition;    //tempinline calculation
        inLine.x=round(InLine.x);
        inLine.y=round(InLine.y);
        inLine.z=round(InLine.z);
        if ((x = round(tempOwnVelocity.x)) == 0)
            tempOwnVelocity.x = 1.0f;
        if ((y = round(tempOwnVelocity.y)) == 0)
            tempOwnVelocity.y = 1.0f;
        if ((z = round(tempOwnVelocity.z)) == 0)
            tempOwnVelocity.z = 1.0f;
        inLine = inLine/tempOwnVelocity;
        return(inLine);
    }

vec3 Seperation(vec3 inLine, vec3 ownPosition, float distance){
        vec3 steer = vec3(0.0,0.0,0.0);
        float tempDistance = 0.02f/distance;



        if (inLine.x > ownPosition.x) {
            steer.x = steer.x - tempDistance;
        } else if (inLine.x < ownPosition.x) {
            steer.x = steer.x + tempDistance;
        }

        if (inLine.y > ownPosition.y) {
            steer.y = steer.y - tempDistance;
        } else if (inLine.y < ownPosition.y) {
            steer.y = steer.y + tempDistance;
        }

        if (inLine.z > ownPosition.z) {
            steer.z = steer.z - tempDistance;
        } else if (inLine.z < ownPosition.z) {
            steer.z = steer.z + tempDistance;
        }

        return steer;
    }

vec3 Align(vec3 inLine, vec3 ownPosition, float distance){
        vec3 steer = vec3(0.0,0.0,0.0);
        float tempDistance = 0.02f/distance;


        if (inLine.x > ownPosition.x) {
            steer.x = steer.x + tempDistance;
        } else if (inLine.x < ownPosition.x) {
            steer.x = steer.x - tempDistance;
        }

        if (inLine.y > ownPosition.y) {
            steer.y = steer.y + tempDistance;
        } else if (inLine.y < ownPosition.y) {
            steer.y = steer.y - tempDistance;
        }

        if (inLine.z > ownPosition.z) {
            steer.z = steer.z + tempDistance;
        } else if (inLine.z < ownPosition.z) {
            steer.z = steer.z - tempDistance;
        }

        return steer;
    }

vec3 Cohestion(vec3 otherVelocity){
        vec3 steer = otherVelocity;
        return steer;
    }