/**
 * 
 */
package org.effrafax.math.algebra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.effrafax.math.algebra.implementations.AbstractRing;
import org.effrafax.math.algebra.interfaces.Field;
import org.effrafax.math.algebra.interfaces.Ring;

/**
 * This matrix provides a means to define matrix element of a matrix ring.
 * 
 * @author Daan van Berkel
 */
public class Matrix<E extends Field<E>> extends AbstractRing<Matrix<E>>
		implements Ring<Matrix<E>> {

	private List<E> elements = new ArrayList<E>();
	private int dimension;

	/**
	 * A constructor for Matrices.
	 * 
	 * @param dimension
	 *            the number of rows and columns this {@code Matrix} should
	 *            have.
	 * @param elements
	 *            the elements which make up this {@code Matrix}.
	 * @throws IllegalArgumentException
	 *             when the elements.size() != dimension * dimension.
	 */
	public Matrix(int dimension, List<E> elements)
			throws IllegalArgumentException {

		if (elements.size() != dimension * dimension) {

			throw new IllegalArgumentException(
					"number of elements do not match the dimension of the matrix.");
		}

		if (elements.contains(null)) {

			throw new IllegalArgumentException("Elements must not be null.");
		}

		this.elements = elements;
		this.dimension = dimension;
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.algebra.interfaces.Ring#getOne()
	 */
	@Override
	public Matrix<E> getOne() {

		E zero = getZeroOfField();
		E one = zero.getOne();

		List<E> elements = new ArrayList<E>();
		elements.addAll(Collections.nCopies(dimension * dimension, zero));
		for (int index = 0; index < dimension; index++) {

			elements.set(index + dimension * index, one);
		}

		return new Matrix<E>(dimension, elements);
	}

	/**
	 * Returns the one element of the field which all the elements of this
	 * {@code Matrix} belong to.
	 * 
	 * @return the one of {@code E}.
	 */
	public E getOneOfField() {

		return getElementAt(0, 0).getOne();
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.algebra.interfaces.Ring#getZero()
	 */
	@Override
	public Matrix<E> getZero() {

		E zero = getZeroOfField();

		List<E> elements = Collections.nCopies(dimension * dimension, zero);

		return new Matrix<E>(dimension, elements);
	}

	/**
	 * Returns the zero element of the field which all the elements of this
	 * {@code Matrix} belong to.
	 * 
	 * @return the zero of {@code E}.
	 */
	public E getZeroOfField() {

		return getElementAt(0, 0).getZero();
	}

	/**
	 * Checks that the dimension of this {@code Matrix} and {@code that} {@code
	 * Matrix} are the same. An exception is thrown otherwise.
	 * 
	 * @param that
	 *            The {@code Matrix} to test the dimension.
	 * @throws IllegalArgumentException
	 *             when the dimension do not correspond.
	 */
	private void checkDimension(Matrix<E> that) throws IllegalArgumentException {

		String exceptionMessage = "dimension mismatch";

		if (this.dimension != that.dimension) {

			throw new IllegalArgumentException(exceptionMessage);
		}
	}

	/**
	 * Returns the dimension of this {@code Matrix}
	 * 
	 * @return The dimension of this {@code Matrix}
	 */
	public int getDimension() {

		return dimension;
	}

	/**
	 * Returns the element at row {@code rowIndex} and column {@code
	 * columnIndex}. Rows and columns are indexed from zero. An
	 * {@link IllegalArgumentException} is thrown when the indices are out of
	 * range.
	 * 
	 * @param rowIndex
	 *            the index of the row. the following constraints apply 0 <=
	 *            {@code rowIndex} < dimension.
	 * @param columnIndex
	 *            the index of the column. The following constraints apply 0 <=
	 *            {@code rowIndex} < dimension.
	 * @return the element at row {@code rowIndex} and column {@code
	 *         columnIndex}.
	 */
	public E getElementAt(int rowIndex, int columnIndex)
			throws IllegalArgumentException {

		if (rowIndex < 0 || this.dimension <= rowIndex || columnIndex < 0
				|| this.dimension <= columnIndex) {

			throw new IllegalArgumentException("indices out of range");
		}

		return elements.get(rowIndex * dimension + columnIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.effrafax.math.algebra.interfaces.Ring#add(org.effrafax.math.algebra
	 * .interfaces.Ring)
	 */
	@Override
	public Matrix<E> add(Matrix<E> that) {

		checkDimension(that);

		List<E> elements = new ArrayList<E>();
		for (int index = 0; index < this.elements.size(); index++) {

			elements
					.add(this.elements.get(index).add(that.elements.get(index)));
		}

		return new Matrix<E>(this.dimension, elements);
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.algebra.interfaces.Ring#isOne()
	 */
	@Override
	public boolean isOne() {

		boolean flag = true;
		for (int rowIndex = 0; rowIndex < dimension; rowIndex++) {

			for (int columnIndex = 0; columnIndex < dimension; columnIndex++) {

				if (rowIndex == columnIndex) {

					flag = getElementAt(rowIndex, columnIndex).isOne();
				} else {

					flag = getElementAt(rowIndex, columnIndex).isZero();
				}

				if (!flag) {

					break;
				}
			}

			if (!flag) {

				break;
			}
		}

		return flag;
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.algebra.interfaces.Ring#isZero()
	 */
	@Override
	public boolean isZero() {

		boolean flag = true;

		int index = 0;
		while (index < dimension && flag) {

			flag = elements.get(index).isZero();
			index++;
		}

		return flag;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.effrafax.math.algebra.interfaces.Ring#multiply(org.effrafax.math.
	 * algebra.interfaces.Ring)
	 */
	@Override
	public Matrix<E> multiply(Matrix<E> that) {

		checkDimension(that);

		/* Fancy way of making zero */
		E zero = getElementAt(0, 0).subtract(getElementAt(0, 0));

		List<E> elements = new ArrayList<E>();
		for (int rowIndex = 0; rowIndex < dimension; rowIndex++) {

			for (int columnIndex = 0; columnIndex < dimension; columnIndex++) {

				E result = zero;
				for (int index = 0; index < dimension; index++) {

					E u = this.getElementAt(rowIndex, index);
					E v = that.getElementAt(index, columnIndex);
					E product = u.multiply(v);

					result = result.add(product);
				}

				elements.add(result);
			}

		}

		return new Matrix<E>(dimension, elements);
	}

	/*
	 * (non-Javadoc)
	 * @see org.effrafax.math.algebra.interfaces.Ring#negative()
	 */
	@Override
	public Matrix<E> negative() {

		List<E> elements = new ArrayList<E>();
		for (E element : this.elements) {

			elements.add(element.negative());
		}

		return new Matrix<E>(dimension, elements);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int prime = 37;

		int result = 1;
		result = prime * result + dimension;
		result = prime * result
				+ ((elements == null) ? 0 : elements.hashCode());

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {

			return true;
		}
		if (obj == null) {

			return false;
		}
		if (getClass() != obj.getClass()) {

			return false;
		}

		Matrix<E> other = (Matrix<E>) obj;
		if (dimension != other.dimension) {

			return false;
		}
		if (elements == null) {

			if (other.elements != null) {

				return false;
			}
		} else if (!elements.equals(other.elements)) {

			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("[");
		for (int rowIndex = 0; rowIndex < dimension; rowIndex++) {

			for (int columnIndex = 0; columnIndex < dimension; columnIndex++) {

				builder.append(" ");
				builder.append(getElementAt(rowIndex, columnIndex));
			}
			builder.append("\n");

		}

		builder.append("]");

		return builder.toString();
	}
}
