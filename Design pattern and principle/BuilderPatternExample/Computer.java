package BuilderPatternExample;

public class Computer {
    private String cpu;
    private String ram;
    private String storage;


    private Computer(Builder builder){

        cpu = builder.cpu;
        ram = builder.ram;
        storage = builder.storage;
    }


    static class Builder{

        private String cpu;
        private String ram;
        private String storage;


        Builder setCPU(String cpu){
            this.cpu = cpu;
            return this;
        }


        Builder setRAM(String ram){
            this.ram = ram;
            return this;
        }


        Builder setStorage(String storage){
            this.storage = storage;
            return this;
        }


        Computer build(){
            return new Computer(this);
        }
    }


    public String toString(){

        return cpu+" "+ram+" "+storage;

    }
    
}
