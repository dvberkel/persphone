/**
 * 
 */
package org.effrafax.math.algebra.util;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.effrafax.math.algebra.GF;
import org.effrafax.math.algebra.Matrix;
import org.junit.Test;

/**
 * @author articles
 */
public class MatrixUtilTest {

	@Test
	public void testRowEcholonFormTrivial() {

		GF fieldZero = new GF(0, 2);
		GF fieldOne = new GF(1, 2);

		Matrix<GF> matrix = new Matrix<GF>(3, Arrays.asList(new GF[] {fieldOne,
				fieldZero, fieldZero, fieldOne, fieldOne, fieldZero, fieldOne,
				fieldOne, fieldOne }));
		Matrix<GF> oneMatrix = matrix.getOne();

		assertEquals(oneMatrix, MatrixUtil.rowEchelonForm(matrix));
	}

	@Test
	public void testRowEcholonForm() {

		GF fieldZero = new GF(0, 3);
		GF fieldOne = new GF(1, 3);
		GF fieldTwo = new GF(2, 3);

		Matrix<GF> matrix = new Matrix<GF>(3, Arrays.asList(new GF[] {fieldOne,
				fieldOne, fieldZero, fieldTwo, fieldOne, fieldZero, fieldOne,
				fieldOne, fieldOne }));
		Matrix<GF> resultMatrix = new Matrix<GF>(3, Arrays.asList(new GF[] {
				fieldOne, fieldOne, fieldZero, fieldZero, fieldTwo, fieldZero,
				fieldZero, fieldZero, fieldOne }));

		assertEquals(resultMatrix, MatrixUtil.rowEchelonForm(matrix));
	}

	@Test
	public void testRowEcholonFormMultiple() {

		GF fieldZero = new GF(0, 3);
		GF fieldOne = new GF(1, 3);
		GF fieldTwo = new GF(2, 3);

		Matrix<GF> matrix = new Matrix<GF>(3, Arrays.asList(new GF[] {fieldOne,
				fieldTwo, fieldZero, fieldTwo, fieldTwo, fieldOne, fieldOne,
				fieldOne, fieldOne }));
		Matrix<GF> resultMatrix = new Matrix<GF>(3, Arrays.asList(new GF[] {
				fieldOne, fieldTwo, fieldZero, fieldZero, fieldOne, fieldOne,
				fieldZero, fieldZero, fieldTwo }));

		assertEquals(resultMatrix, MatrixUtil.rowEchelonForm(matrix));
	}
}
