package witstore.Tools;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Tools{
    public static String encryption(Object credentials){
        String hashAlgorithmName="MD5";
        String SALT = "mar%#$@";
        int hashIterations=6;
        return new SimpleHash(hashAlgorithmName,credentials, ByteSource.Util.bytes(SALT),hashIterations).toHex();
    }
}
