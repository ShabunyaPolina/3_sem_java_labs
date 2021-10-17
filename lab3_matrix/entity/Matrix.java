package lab.entity;

import lab.exception.MatrixException;

public class Matrix {
    private double[][] a;

    public Matrix(double[][] a) {
        this.a = a;
    }

    public Matrix(int n, int m) throws MatrixException {
        if (n < 1 || m < 1)
            throw new MatrixException("Invalid matrix size");
        a = new double[n][m];
    }

    // copy constructor
    public Matrix(Matrix matrix) {
        int n = matrix.getVerticalSize();
        int m = matrix.getHorizontalSize();
        a = new double[n][m];
        for (int i = 0; i < n; ++i) {
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

    public double getElement(int i, int j) throws MatrixException {
        if (checkRange(i, j))
            return a[i][j];
        else
            throw new MatrixException("Index out of bounds");
    }

    public void setElement(int i, int j, double value) throws MatrixException {
        if (checkRange(i, j))
            a[i][j] = value;
        else
            throw new MatrixException("Index out of bounds");
    }

    @Override
    public String toString() {
        final String BLANK = " ";
        StringBuilder s = new StringBuilder();
        String formattedValue;
        for (double[] row : a) {
            for (double value : row) {
                formattedValue = String.format("%.2f", value);
                s.append(formattedValue).append(BLANK);
            }
            s.append("\n");
        }
        return s.toString();
    }

    private boolean checkRange(int i, int j) {
        return i >= 0 && i < a.length && j >= 0 && j < a[0].length;
    }
}
