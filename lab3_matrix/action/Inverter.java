package lab.action;

import lab.entity.Matrix;
import lab.exception.MatrixException;

public class Inverter {
    public Matrix invertMatrix(Matrix matrix) throws MatrixException {
        int n = matrix.getVerticalSize();
        Decomposer decomposer = new Decomposer();
        Matrix lu = new Matrix(decomposer.decomposeOnLU(matrix));
        Matrix invertedMatrix = new Matrix(n, n);
        double[] tmp = new double[n];
        double[] x = new double[n];
        int[] b = new int[n];
        double s = 0;

        // identity matrix column
        for (int k = 0; k < n; ++k) {
            if (k != 0)
                b[k - 1] = 0;
            b[k] = 1;

            // L*tmp=b, tmp = U*t
            for (int i = 0; i < n; ++i) {
                tmp[i] = b[i];
                for (int j = 0; j < i; ++j) {
                    tmp[i] -= lu.getElement(i, j) * tmp[j];
                }
            }

            // U*x=tmp
            for (int i = n - 1; i >= 0; --i) {
                for (int j = n - 1; j > i; --j) {
                    s += lu.getElement(i, j) * x[j];
                }
                x[i] = (tmp[i] - s) / lu.getElement(i, i);
                s = 0;
            }

            // adding a ready column to the inverse matrix
            for (int i = 0; i < n; ++i) {
                invertedMatrix.setElement(i, k, x[i]);
            }
        }
        return invertedMatrix;
    }
}
