#version 400 core

in vec2 pass_textureCoordinate;
in vec3 surfaceNormal;
in vec3 toLightVector;
in vec3 toCameraVector;

out vec4 out_Color;

uniform sampler2D textureSampler;
uniform vec3 lightColor;
uniform vec3 outLineColor;
uniform float shineDamper;
uniform float reflectivity;
uniform float toon;

void main(void){

    vec3 unitNormal = normalize(surfaceNormal);
    vec3 unitLightVector = normalize(toLightVector);

    float nDot1 = dot(unitNormal,unitLightVector);
    float brightness = max(nDot1,0.0);
    vec3 diffuse = brightness * lightColor;

    vec3 unitVectorToCamera = normalize(toCameraVector);
    vec3 lightDirection = -unitLightVector;
    vec3 reflectedLightDirection = reflect(lightDirection,unitNormal);

    float specularFactor = dot(reflectedLightDirection,unitVectorToCamera);
    specularFactor = max(specularFactor,0.0);
    float dampedFactor = pow(specularFactor,shineDamper);
    vec3 finalSpecular = dampedFactor * reflectivity * lightColor;

    float toonFactor = dot(unitNormal,unitVectorToCamera);
    toonFactor = max(toonFactor,0.001);

    vec4 texturein=texture(textureSampler,pass_textureCoordinate);
    if(toonFactor < (0.01*toon)){
    out_Color=vec4(outLineColor,.10) + vec4(finalSpecular,1.0);
    }else{
    out_Color = (vec4(diffuse,1.0) * texturein) + vec4(finalSpecular,1.0);
    }
}