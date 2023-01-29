package hello.core.singleton;

public class SingletonService {

    //자기 자신을 static으로 하나 선언
    private static final SingletonService instance= new SingletonService();

    //instance 생성은 아래 코드 밖에 못한다.
    public static SingletonService getInstance(){
        return instance;
    }

    //private 생성자로 만들면 다른 곳에서 객체 생성이 불가해진다.
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
