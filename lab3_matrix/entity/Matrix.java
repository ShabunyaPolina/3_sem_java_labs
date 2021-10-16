package lab.entity;

public class Matrix {
    private double[][] a;

    public Matrix(double[][] a) {
        this.a = a;
    }

    public Matrix(int n, int m) {
        a = new double[n][m];
    }

    public Matrix(Matrix matrix) {
        int n = matrix.getVerticalSize();
        int m = matrix.getHorizontalSize();
        a = new double[n][m];
        for (int i = 0; i < n; ++i){
            System.arraycopy(matrix.getArray()[i], 0, a[i], 0, m);
        }
    }

    private double[][] getArray() {
        return a;
    }

    public int getVerticalSize() {
        return a.length;
    }

    public int getHorizontalSize() {
        return a[0].length;
    }

    public double getElement(int i, int j) {
        return a[i][j];
    }

    public void setElement(int i, int j, double value) {
        a[i][j] = value;
    }

    @Override
    public String toString() {
        final String BLANK = " ";
        StringBuilder s = new StringBuilder("\nMatrix : " + a.length + "x"
                + a[0].length + "\n");
        for (double[] row : a) {
            for (double value : row) {
                s.append(value).append(BLANK);
            }
            s.append("\n");
        }
        return s.toString();
    }

    private boolean checkRange(int i, int j) {
        return i >= 0 && i < a.length && j >= 0 && j < a[0].length;
    }
}
