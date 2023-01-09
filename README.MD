## standalone-epsilon ##
This is a simple maven project that integrate Epsilon.
It creates a class that encapsulate the required functionalities for running eol 
scripts over an ecore model.

The models are in the path: **./scripts/eol/example_models**
The eol that query the architectural model is the main.eol
Here a snippet of the function that perform the .eol integration

```java
/**
     * @param eolScript: Name of the .eol script
     * @param modelPath: Path of the aaxl2 instance model
     * @return Map that contains the result of several metrics computed over the model
     * @throws Exception
     */
    public Object run(String eolScript, String modelPath) throws Exception {
        if (eolScript == null)
            eolScript = "main";
        EolModule module = new EolModule();
        Path rootPath = Paths.get("scripts", "eol").toAbsolutePath();
        String eolPath = rootPath.resolve(eolScript + ".eol").toString();
        String metaModelPath = Paths.get("ecore", "aadl2_inst.ecore").toAbsolutePath().toString();
        EmfModel model = createEmfModel("ModelImpl", modelPath, metaModelPath, true, false);
        module.parse(new File(eolPath));
        module.getContext().getModelRepository().addModel(model);
        return module.execute();
    }

```
