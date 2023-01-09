package org.standalone.epsilon.example;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        EolRunner eolRunner = EolRunner.getInstance();
        String modelOnePath = Paths.get("scripts", "eol", "example_models", "SecuritySystem_Impl.aaxl2").toAbsolutePath().toString();
        String modelTwoPath = Paths.get("scripts", "eol", "example_models", "UAS_Impl.aaxl2").toAbsolutePath().toString();
        try {
            System.out.println("---------------Running the script for the model: " + modelOnePath +" ----------------------------");
            Object res1 = eolRunner.run(modelOnePath);
            System.out.println("Output 1: " + res1);
            System.out.println("\n---------------Running the script for the model: " + modelTwoPath +" ----------------------------");
            Object res2 = eolRunner.run(modelTwoPath);
            System.out.println("Output 2: " + res1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
