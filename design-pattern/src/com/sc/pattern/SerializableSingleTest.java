package com.sc.pattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import com.sc.pattern.singleton.SerilizableSingleton;

public class SerializableSingleTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		SerilizableSingleton instanceOne = SerilizableSingleton.getInstance();

		ObjectOutput output = new ObjectOutputStream(new FileOutputStream("test.ser"));
		output.writeObject(instanceOne);
		output.close();

		ObjectInput input = new ObjectInputStream(new FileInputStream("test.ser"));
		SerilizableSingleton intanceTwo = (SerilizableSingleton) input.readObject();
		input.close();
		
		System.out.println("Instance 1::"+instanceOne.hashCode());
		System.out.println("Instance 2::"+intanceTwo.hashCode());

	}

}
