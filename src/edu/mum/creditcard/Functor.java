package edu.mum.creditcard;

public interface Functor<T,R> {
	public void compu(T t);
	public R getResult();
}
