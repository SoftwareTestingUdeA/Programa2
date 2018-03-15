package com.udea.testing.program1.statisticsService;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.udea.testing.program1.statisticsService.model.Node;
import com.udea.testing.program1.statisticsService.model.NumberLinkedList;
import com.udea.testing.program1.statisticsService.model.NumberSet;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberSetTests {

    NumberLinkedList list = null;

    @Test
	public void calculateCorrelationTest1() {
		Node nodeTen = new Node(Double.parseDouble("961"), Double.parseDouble("1601"), null);
		Node nodeNine = new Node(Double.parseDouble("368"), Double.parseDouble("788"), nodeTen);
		Node nodeEight = new Node(Double.parseDouble("945"), Double.parseDouble("1890"), nodeNine);
		Node nodeSeven = new Node(Double.parseDouble("95"), Double.parseDouble("199"), nodeEight);
		Node nodeSix = new Node(Double.parseDouble("302"), Double.parseDouble("331"), nodeSeven);
		Node nodeFive = new Node(Double.parseDouble("128"), Double.parseDouble("291"), nodeSix);
		Node nodeFour = new Node(Double.parseDouble("150"), Double.parseDouble("272"), nodeFive);
	    Node nodeThree = new Node(Double.parseDouble("99"), Double.parseDouble("132"), nodeFour);
	    Node nodeTwo = new Node(Double.parseDouble("650"), Double.parseDouble("699"), nodeThree);
	    Node nodeOne = new Node(Double.parseDouble("130"), Double.parseDouble("186"), nodeTwo);
	    list = new NumberLinkedList(nodeOne, nodeTen, 10);
	    
	    NumberSet numberSet = new NumberSet();
	    numberSet.setList(list);
	    numberSet.calculateCorrelation();
	    assertEquals("", "-22.552532752034267/1.727932426206986/0.9544965741046826/0.9110637099775758/644.4293837638623", String.valueOf(numberSet.getBeta0()) + "/" +  String.valueOf(numberSet.getBeta1()) + "/" + String.valueOf(numberSet.getCorrelation()) + "/" +  String.valueOf(numberSet.getCorrelationPow()) + "/" + String.valueOf(numberSet.getYk(386)));
	}
	
	@Test
	public void calculateCorrelationTest2() {
		Node nodeTen = new Node(Double.parseDouble("961"), Double.parseDouble("138.2"), null);
		Node nodeNine = new Node(Double.parseDouble("368"), Double.parseDouble("38.8"), nodeTen);
		Node nodeEight = new Node(Double.parseDouble("945"), Double.parseDouble("198.7"), nodeNine);
		Node nodeSeven = new Node(Double.parseDouble("95"), Double.parseDouble("19.4"), nodeEight);
		Node nodeSix = new Node(Double.parseDouble("302"), Double.parseDouble("65.9"), nodeSeven);
		Node nodeFive = new Node(Double.parseDouble("128"), Double.parseDouble("28.4"), nodeSix);
		Node nodeFour = new Node(Double.parseDouble("150"), Double.parseDouble("22.4"), nodeFive);
	    Node nodeThree = new Node(Double.parseDouble("99"), Double.parseDouble("6.5"), nodeFour);
	    Node nodeTwo = new Node(Double.parseDouble("650"), Double.parseDouble("69.9"), nodeThree);
	    Node nodeOne = new Node(Double.parseDouble("130"), Double.parseDouble("15.0"), nodeTwo);
	    list = new NumberLinkedList(nodeOne, nodeTen, 10);
	    
	    NumberSet numberSet = new NumberSet();
	    numberSet.setList(list);
	    numberSet.calculateCorrelation();
	    assertEquals("", "-4.038881574687551/0.16812664988162895/0.9333068981405511/0.871061766116737/60.858005279621224", String.valueOf(numberSet.getBeta0()) + "/" +  String.valueOf(numberSet.getBeta1()) + "/" + String.valueOf(numberSet.getCorrelation()) + "/" +  String.valueOf(numberSet.getCorrelationPow()) + "/" +String.valueOf(numberSet.getYk(386)));
	}
	
	@Test
	public void calculateCorrelationTest3() {
		Node nodeTen = new Node(Double.parseDouble("1130"), Double.parseDouble("1601"), null);
		Node nodeNine = new Node(Double.parseDouble("433"), Double.parseDouble("788"), nodeTen);
		Node nodeEight = new Node(Double.parseDouble("1206"), Double.parseDouble("1890"), nodeNine);
		Node nodeSeven = new Node(Double.parseDouble("136"), Double.parseDouble("199"), nodeEight);
		Node nodeSix = new Node(Double.parseDouble("355"), Double.parseDouble("331"), nodeSeven);
		Node nodeFive = new Node(Double.parseDouble("137"), Double.parseDouble("291"), nodeSix);
		Node nodeFour = new Node(Double.parseDouble("166"), Double.parseDouble("272"), nodeFive);
	    Node nodeThree = new Node(Double.parseDouble("141"), Double.parseDouble("132"), nodeFour);
	    Node nodeTwo = new Node(Double.parseDouble("765"), Double.parseDouble("699"), nodeThree);
	    Node nodeOne = new Node(Double.parseDouble("163"), Double.parseDouble("186"), nodeTwo);
	    list = new NumberLinkedList(nodeOne, nodeTen, 10);
	    
	    NumberSet numberSet = new NumberSet();
	    numberSet.setList(list);
	    numberSet.calculateCorrelation();
	    numberSet.getBeta0();
	    numberSet.getBeta1();
	    numberSet.getCorrelation();
	    numberSet.getCorrelationPow();
	    numberSet.getYk(386);
	    assertEquals("", "-23.92388825291539/1.430966943551199/0.9631140931490527/0.9275887564223222/528.4293519578474", String.valueOf(numberSet.getBeta0()) + "/" +  String.valueOf(numberSet.getBeta1()) + "/" + String.valueOf(numberSet.getCorrelation()) + "/" +  String.valueOf(numberSet.getCorrelationPow()) + "/" +String.valueOf(numberSet.getYk(386)));
	}
	
	@Test
	public void calculateCorrelationTest4() {
		Node nodeTen = new Node(Double.parseDouble("1130"), Double.parseDouble("138.2"), null);
		Node nodeNine = new Node(Double.parseDouble("433"), Double.parseDouble("38.8"), nodeTen);
		Node nodeEight = new Node(Double.parseDouble("1206"), Double.parseDouble("198.7"), nodeNine);
		Node nodeSeven = new Node(Double.parseDouble("136"), Double.parseDouble("19.4"), nodeEight);
		Node nodeSix = new Node(Double.parseDouble("355"), Double.parseDouble("65.9"), nodeSeven);
		Node nodeFive = new Node(Double.parseDouble("137"), Double.parseDouble("28.4"), nodeSix);
		Node nodeFour = new Node(Double.parseDouble("166"), Double.parseDouble("22.4"), nodeFive);
	    Node nodeThree = new Node(Double.parseDouble("141"), Double.parseDouble("6.5"), nodeFour);
	    Node nodeTwo = new Node(Double.parseDouble("765"), Double.parseDouble("69.9"), nodeThree);
	    Node nodeOne = new Node(Double.parseDouble("163"), Double.parseDouble("15.0"), nodeTwo);
	    list = new NumberLinkedList(nodeOne, nodeTen, 10);
	    
	    NumberSet numberSet = new NumberSet();
	    numberSet.setList(list);
	    numberSet.calculateCorrelation();
	    numberSet.getBeta0();
	    numberSet.getBeta1();
	    numberSet.getCorrelation();
	    numberSet.getCorrelationPow();
	    numberSet.getYk(386);
	    assertEquals("", "-4.6037454233089505/0.14016352638883628/0.9480329874300507/0.8987665452555467/49.49937576278185", String.valueOf(numberSet.getBeta0()) + "/" +  String.valueOf(numberSet.getBeta1()) + "/" + String.valueOf(numberSet.getCorrelation()) + "/" +  String.valueOf(numberSet.getCorrelationPow()) + "/" +String.valueOf(numberSet.getYk(386)));
	}
}
