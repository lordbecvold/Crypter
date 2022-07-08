package xyz.becvar.crypter.utils;

import java.io.File;

public class FileUtils {

    public static boolean isWordlistValid(String path) {
        if (path.isEmpty() || !(new File(path).exists())) {
            return false;

        } else {
            return true;
        }
    }
}
