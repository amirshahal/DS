
// Provided by Inon Barnea, Aug 1st 2022
package com.example.datastructure;

public class BinNode<T> {
	private BinNode<T> left;
	private T value;
	private BinNode<T> right;

	public BinNode(T x) {
		this.left = null;
	    this.value = x;
	    this.right = null;
	}

	public BinNode(BinNode<T> left, T x, BinNode<T> right) {
		this.left = left;
	    this.value = x;
	    this.right = right;
	}

	public T getValue() {
		return this.value;
	}

	public void setValue(T x) {
		this.value = x;
	}

	public BinNode<T> getLeft() {
		return this.left;
	}

    public BinNode<T> getRight() {
        return this.right;
    }

    public void setLeft(BinNode<T> left) {
        this.left = left;
    }

    public void setRight(BinNode<T> right) {
        this.right = right;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public String toString() {
        return this.value.toString();
    }
}
