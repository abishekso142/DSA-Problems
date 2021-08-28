import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class PasswordCharArray
{

    public static void main(final String[] args)
    {
        appendChars();
    }

    public static void appendChars()
    {
        final char[] user    = "UserNameExample".toCharArray();
        final char[] pwd     = "PasswordExample".toCharArray();
        final char[] authArr = new char[user.length + pwd.length + 1];

        int ctr = 0;
        // Append the character arrays
        for (int i = 0; i < authArr.length; i++)
        {
            if (i < user.length)
            {
                authArr[i] = user[i];
            }
            else if (i == user.length)
            {
                authArr[i] = ':';
            }
            else
            {
                authArr[i] = pwd[ctr++];
            }
        }

        // Convert to byte array n encode
        final CharBuffer charBuffer   = CharBuffer.wrap(authArr);
        final ByteBuffer byteBuffer   = Charset.forName("UTF-8").encode(charBuffer);
        final byte[]     bytes        = Arrays.copyOfRange(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
        final byte[]     encodedAuth1 = Base64.getEncoder().encode(bytes);
        final String     authHeader1  = "Basic " + new String(encodedAuth1, StandardCharsets.UTF_8);

        // Clear all local arrays
        Arrays.fill(authArr, ' ');
        Arrays.fill(bytes, (byte) 0);
        Arrays.fill(byteBuffer.array(), (byte) 0);
    }
}
