

public class Nil extends List {

    @Override
    public String toString() {
        return "";
    }


    @Override
    public List add(int x, int i) {
        return new Node(x, this);
    }

    @Override
    public List remove(int x) {
        return this;
    }



    @Override
    public int countOdd() {
        return 0;
    }


  @Override
    public List doubleValue() {
    return this;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Node)
            return false;
       return true;
    }

    @Override
    public List getNext(){
        return this;
    }

}
