import java.util.Random;

public class DataGenerator {
    private int [] _dataArray;
    private int _dataSize;
    public DataGenerator()
    {
        this._dataArray = null;
        this._dataSize = 0;
    }

    public void generateSequentialData(int size)
    {
        this._dataArray = new int[size];
        this._dataArray[0] = -1;
        this._dataSize = size;
        for(int i = 1; i < size; i++)
            this._dataArray[i] = i;
    }

    public void generateReverseData(int size)
    {
        this._dataArray = new int[size];
        this._dataArray[0] = -1;
        this._dataSize = size;
        for(int i = 1; i < size; i++)
            this._dataArray[i] = size - i;
    }

    public void generateRandomData(int size)
    {
        Random random = new Random();
        this._dataArray = new int[size];
        this._dataArray[0] = -1;
        this._dataSize = size;
        for(int i = 1; i < size; i++)
            this._dataArray[i] = random.nextInt(size);
    }

    public Integer[] getData(int size)
    {
        Integer [] copyArray = new Integer[size];
        for(int i = 0; i < size; i++)
            copyArray[i] = this._dataArray[i];
        return copyArray;
    }
}