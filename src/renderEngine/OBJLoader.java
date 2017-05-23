package renderEngine;

import Vektor.Vektor2D;
import Vektor.Vektor3D;
import models.RawModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ezydenias on 5/23/2017.
 */

public class OBJLoader {

    public static RawModel loadObjModel(String fileName, Loader loader) {
        FileReader fr = null;
        try {
            fr = new FileReader((new File("res/" + fileName + ".obj")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(fr);
        String line;
        List<Vektor3D> vertices = new ArrayList<Vektor3D>();
        List<Vektor2D> textures = new ArrayList<Vektor2D>();
        List<Vektor3D> normals = new ArrayList<Vektor3D>();
        List<Integer> indices = new ArrayList<Integer>();
        double[] verticesArray = null;
        double[] normalArray = null;
        double[] textureArray = null;
        int[] indicesArrray = null;
        try {
            while (true) {
                line = reader.readLine();
                String[] currentLine = line.split(" ");
                if (line.startsWith("v ")) {
                    Vektor3D vertex = new Vektor3D(Double.parseDouble(currentLine[1]), Double.parseDouble((currentLine[2])), Double.parseDouble((currentLine[3])));
                    vertices.add(vertex);
                } else if (line.startsWith("vt ")) {
                    Vektor2D texture = new Vektor2D(Double.parseDouble(currentLine[1]), Double.parseDouble(currentLine[2]));
                    textures.add(texture);
                } else if (line.startsWith("vn ")) {
                    Vektor3D normal = new Vektor3D(Double.parseDouble(currentLine[1]), Double.parseDouble((currentLine[2])), Double.parseDouble((currentLine[3])));
                    normals.add(normal);
                } else if (line.startsWith("f ")) {
                    textureArray = new double[vertices.size() * 2];
                    normalArray = new double[vertices.size() * 3];
                    break;
                }
            }

            while (line != null) {
                if (!line.startsWith("f ")) {
                    line = reader.readLine();
                    continue;
                }
                String[] currentLine = line.split(" ");
                String[] vertex1 = currentLine[1].split("/");
                String[] vertex2 = currentLine[2].split("/");
                String[] vertex3 = currentLine[3].split("/");

                processVertex(vertex1, indices, textures, normals, textureArray, normalArray);
                processVertex(vertex2, indices, textures, normals, textureArray, normalArray);
                processVertex(vertex3, indices, textures, normals, textureArray, normalArray);
                line = reader.readLine();
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        verticesArray = new double[vertices.size() * 3];
        indicesArrray = new int[indices.size()];

        int vertexPointer = 0;
        for (Vektor3D vertex : vertices) {
            verticesArray[vertexPointer++] = vertex.x;
            verticesArray[vertexPointer++] = vertex.y;
            verticesArray[vertexPointer++] = vertex.z;
        }

        for (int i = 0; i < indices.size(); i++) {
            indicesArrray[i] = indices.get(i);
        }
        return loader.loadToVAO(verticesArray, textureArray,normalArray, indicesArrray);
    }

    private static void processVertex(String[] vertexData, List<Integer> indices, List<Vektor2D> textures, List<Vektor3D> normals, double[] textureArray, double[] normalsArray) {
        int currentVertexPointer = Integer.parseInt(vertexData[0]) - 1;
        indices.add(currentVertexPointer);
        Vektor2D currentTex = textures.get(Integer.parseInt(vertexData[1]) - 1);
        textureArray[currentVertexPointer * 2] = currentTex.x;
        textureArray[currentVertexPointer * 2+1] = 1 - currentTex.y;
        Vektor3D currentNorm = normals.get(Integer.parseInt(vertexData[2]) - 1);
        normalsArray[currentVertexPointer * 3] = currentNorm.x;
        normalsArray[currentVertexPointer * 3+1] = currentNorm.y;
        normalsArray[currentVertexPointer * 3+2] = currentNorm.z;
    }

}
