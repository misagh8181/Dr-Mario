package ir.ac.kntu;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class ObjectOutput extends ObjectOutputStream {// stackoverflow solution

    protected ObjectOutput(OutputStream os) throws IOException, SecurityException {
        super(os);
    }

    protected void writeStreamHeader() throws IOException {
        File file = new File("abc.txt");
        if (file.exists()) {
            reset();
        } else {
            file.createNewFile();
            super.writeStreamHeader();
        }
    }

}