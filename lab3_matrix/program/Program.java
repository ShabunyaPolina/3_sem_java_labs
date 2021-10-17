package lab.program;

import lab.action.Multiplicator;
import lab.entity.Matrix;
import lab.creator.MatrixCreator;
import lab.action.Decomposer;
import lab.action.Inverter;

import java.io.File;

public class Program {
    public static void main(String[] args) throws Exception {
        Matrix m = new Matrix(3, 3);

        MatrixCreator mc = new MatrixCreator();
        mc.createFromFile(m, new File("data.txt"));

        System.out.println("Matrix:\n" + m);

        Decomposer d = new Decomposer();
        System.out.println("LU-decomposition:\n" + d.decomposeOnLU(m));

        Inverter inv = new Inverter();
        Matrix inverseMatrix = inv.invertMatrix(m);
        System.out.println("Inverse matrix:\n" + inverseMatrix);

        Multiplicator productMatrix = new Multiplicator();
        System.out.println("Check:\n" + m + "(*)\n" + inverseMatrix +
                "(=)\n" + productMatrix.multiply(m, inverseMatrix));
    }
}
