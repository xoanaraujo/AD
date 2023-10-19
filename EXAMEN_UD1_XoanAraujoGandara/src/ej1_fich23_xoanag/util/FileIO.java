package ej1_fich23_xoanag.util;

import java.io.File;

public abstract class FileIO {

    protected File mainFile;

    public FileIO(File mainFile) {
        this.mainFile = mainFile;
    }

    public abstract void open();
    public abstract void close();


}
