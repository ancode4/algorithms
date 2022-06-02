package interview_practice.wellsfargo.markerinterface;

import java.io.*;

class S implements Serializable
{
    int i;
    String s;

    // S class constructor
    public S(int i,String s)
    {
        this.i = i;
        this.s = s;
    }
}

public class SerializableTest
{
    public static void main(String[] args)
            throws IOException, ClassNotFoundException
    {
        S a = new S(20,"GeeksForGeeks");

        // Serializing 'a'
        FileOutputStream fos = new FileOutputStream("xyz.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a);

        // De-serializing 'a'
        FileInputStream fis = new FileInputStream("xyz.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        S b = (S)ois.readObject();//down-casting object

        System.out.println(b.i+" "+b.s);

        // closing streams
        oos.close();
        ois.close();
    }
}