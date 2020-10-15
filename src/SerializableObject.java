/*
- Try to:
    - dump the object using argument 'write'
    - read the object from file using argument 'read'
    - change the dump and see what happens
    - change the String contents in the dump without changing its size
 */

import java.io.*;

public class SerializableObject implements Serializable {
    private String field;

    SerializableObject( String field ) {
        this.field = field;
    }

    public String toString() {
        return field;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
    }

    static public void main (String[] args) {
        String fileName = "dump.bin";

        if (args.length == 1) {
            String command = args[0];

            if (command.equals( "write" )) {

                SerializableObject object = new SerializableObject("Eduardo");

                try (
                        ObjectOutputStream s =
                                new ObjectOutputStream(new FileOutputStream(fileName));
                ) {
                    s.writeObject(object);
                    System.out.printf( "Object \'%s\' wrote to file dump.bin",
                            object );
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }

            else if (command.equals("read")) {

                try (
                        ObjectInputStream s =
                                new ObjectInputStream(new FileInputStream(fileName) );
                ) {
                    SerializableObject object = (SerializableObject) s.readObject();
                    System.out.println("object = " + object);
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
                catch(ClassNotFoundException e){
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }

            else
                System.out.printf("I dont know what you mean by \'%s\'", args[0]);

        }

        else
            System.out.println("Something wrong is not right");

    }

}
