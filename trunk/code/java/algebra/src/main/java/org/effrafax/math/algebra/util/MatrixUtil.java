/**
 * 
 */
package org.effrafax.math.algebra.util;

import org.effrafax.math.algebra.Matrix;
import org.effrafax.math.algebra.interfaces.Field;

/**
 * @author Daan van Berkel
 */
public class MatrixUtil {

	public static <E extends Field<E>> Matrix<E> rowEchelonForm(Matrix<E> matrix) {

		int dimension = matrix.getDimension();
		int offset = 0;
		for (int columnIndex = 0; columnIndex < dimension; columnIndex++) {

			int referenceIndex = columnIndex - offset;
			int rowIndex = referenceIndex;
			while (rowIndex < dimension
					&& matrix.getElementAt(rowIndex, columnIndex).isZero()) {

				rowIndex++;
			}

			if (rowIndex < dimension && rowIndex != columnIndex) {

				matrix = matrix.swapRows(rowIndex, columnIndex);
			}

			if (!matrix.getElementAt(referenceIndex, columnIndex).isZero()) {

				rowIndex = referenceIndex + 1;
				while (rowIndex < dimension) {

					if (!matrix.getElementAt(rowIndex, columnIndex).isZero()) {

						E scalar = matrix.getElementAt(rowIndex, columnIndex)
								.divide(
										matrix.getElementAt(referenceIndex,
												columnIndex));
						matrix = matrix.rowAdd(scalar.negative(),
								referenceIndex, rowIndex);
					}
					rowIndex++;
				}
			} else {

				offset++;
			}
		}

		return matrix;
	}
}
