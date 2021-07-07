


public class  MyList <T> {
    private T[] list;
    private int size = 0;

    public MyList()
    {
        this.list = (T[])new Object[10];
    }

    public MyList(int capacity)
    {
        this.list = (T[])new Object[capacity];
    }

    public int getCapacity()
    {
        return this.list.length;
    }

    public void add(T data)
    {

        for (int i = 0; i < this.list.length; i++)
        {
            if (this.list[i] == null)
            {
                this.list[i] = data;
                return;
            }

        }

        T[] doubleList = (T[])new Object[this.list.length * 2];

        for (int i = 0; i < this.list.length; i++)
        {
            doubleList[i] = this.list[i];
        }

        doubleList[this.list.length] = data;
        this.list = doubleList;


    }

    public T get(int index)
    {
        if (index >= this.list.length || index < 0)
        {
            System.out.println("Invalid index.");
            return null;
        }
        return list[index];
    }

    public T remove(int index)
    {

        if (index >= this.list.length || index < 0)
        {
            System.out.println("Invalid index");
            return null;
        }

        T returnValue = this.list[index];

        for (int i = index; i < this.list.length - 1; i ++)
        {
            this.list[index] = this.list[index + 1];
        }

        this.list[this.list.length - 1] = null;

        return returnValue;
    }

    public T set(int index, T data)
    {
        if (index >= this.list.length || index < 0)
        {
            System.out.println("Invalid index");
            return null;
        }

        T returnValue = this.list[index];

        this.list[index] = data;

        return returnValue;

    }

    public String toString()
    {
        String list = "";

        list += "[";
        for (int i = 0; i < this.list.length;i++)
        {
            if (this.list[i] != null)
            {
                list += this.list[i];

            }
            if (i != this.list.length - 1 && this.list[i+1] != null) list+=", ";
        }
        list += "]";

        return list;
    }

    public int indexOf(T data)
    {
        for (int i = 0; i < this.list.length;i++)
        {
            if (this.list[i] == data) return i;
        }

        return -1;
    }

    public int lastIndexOf(T data)
    {
        for (int i = this.list.length - 1; i >= 0;i--)
        {
            if (this.list[i] == data) return i;
        }

        return -1;
    }

    public boolean isEmpty()
    {
        return this.list[0] == null;
    }

    public T[] toArray()
    {
        int length = 0;
        for (int i = 0; i <this.list.length;i++)
        {
            if (this.list[i] == null)
            {
                length = i;
                break;
            }
            if (i == this.list.length - 1)
            {
                length = this.list.length;
            }
        }

        T[] array = (T[])new Object[length];

        for (int i = 0; i < length;i++)
        {
            array[i] = this.list[i];
        }

        return array;

    }

    public void clear()
    {
        this.list = (T[])new Object[this.list.length];
    }

    public MyList<T> subList(int start, int finish)
    {

        if (start > finish || start < 0 || start >= this.list.length || finish < 0 || finish >= this.list.length)
        {
            System.out.println("Invalid sublist");
            return null;
        }

        MyList<T> sublist = new MyList<>();

        for (int i = start;i <= finish;i++)
        {
            sublist.add(this.list[i]);
        }


        return sublist;

    }

    public boolean contains(T data)
    {
        for (T ele: this.list)
        {
            if (ele == data) return true;
        }

        return false;
    }

}
