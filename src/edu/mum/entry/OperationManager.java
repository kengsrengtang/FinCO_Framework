package edu.mum.entry;

import java.util.ArrayList;
import java.util.List;

public class OperationManager {
	List<IOperation> operations = new ArrayList<>();
	public void sumbit(IOperation operation){
		operations.add(operation);
		operation.execute();
	}
}
