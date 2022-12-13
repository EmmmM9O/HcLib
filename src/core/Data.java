package core;

public class Data <T>{
    T data;
    public Data(){

    }
    public Data(T t) {
        data = t;
    }
    public T get(){
        return data;
    }
}
