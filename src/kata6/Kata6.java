package kata6;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.zip.ZipInputStream;

public class Kata6 {
    
    private int fic = 0;
    private File file;
    private Iterator<Integer> iterator;
    
    public static void main(String[] args) {
        
        Kata6 kata6 = new Kata6();
        kata6.execute();
        
    }
    
    public void execute(){
        input();
        process();
        output();
    }
    
    public void input(){
        
        file = new File("/");
    }   
    
    public void process(){
        
        iterator = megabytes(lengthsOf(iteratorOf(file.listFiles())));
    }
    
    public void output(){
        
        while (iterator.hasNext()){ 
            System.out.println(iterator.next());
            fic++;
        }
        System.out.println("numero de ficheros accedidos: " + fic);
    }
    
    private static Iterator<Integer> megabytes(Iterator<Long> iterator) {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return (int) (iterator.next() / (1024*1024));
            }
        };
    }

    private static Iterator<Long> lengthsOf(Iterator<File> iterator) {
        return new Iterator<Long>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Long next() {
                return iterator.next().length();
            }
        };
    }
    

    private static <T> Iterator<T> iteratorOf(T[] items) {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < items.length;
            }

            @Override
            public T next() {
                return items[index++];
            }
        };
    }

}
