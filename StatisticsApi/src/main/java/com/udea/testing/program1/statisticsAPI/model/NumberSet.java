package com.udea.testing.program1.statisticsAPI.model;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.1
 */
public class NumberSet {
    String id;
    Double[] setX;
    Double[] setY;
    NumberLinkedList list;
    Double meanX;
    Double meanY;
    Double correlation;
    Double beta0;
    Double beta1;

    public NumberSet() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double[] getSetX() {
        return setX;
    }

    public void setSetX(Double[] setX) {
        this.setX = setX;
    }

    public Double[] getSetY() {
        return setY;
    }

    public void setSetY(Double[] setY) {
        this.setY = setY;
    }

    public NumberLinkedList getList() {
        return list;
    }

    public void setList(NumberLinkedList list) {
        this.list = list;
    }

    public Double getMeanX() {
        return meanX;
    }

    public void setMeanX(Double meanX) {
        this.meanX = meanX;
    }

    public Double getMeanY() {
        return meanY;
    }

    public void setMeanY(Double meanY) {
        this.meanY = meanY;
    }

    public Double getCorrelation() {
        return correlation;
    }

    public void setCorrelation(Double correlation) {
        this.correlation = correlation;
    }

    public Double getBeta0() {
        return beta0;
    }

    public void setBeta0(Double beta0) {
        this.beta0 = beta0;
    }

    public Double getBeta1() {
        return beta1;
    }

    public void setBeta1(Double beta1) {
        this.beta1 = beta1;
    }

    public void calculateMean() {
        Node node = this.getList().getFirst();
        this.setMeanX(0.0);
        this.setMeanY(0.0);
        while (node != null) {
            this.meanX = this.meanX + node.getX();
            this.meanY = this.meanY + node.getY();

            node = node.getLink();
        }
        this.meanX = this.meanX / this.getList().getSize();
        this.meanY = this.meanY / this.getList().getSize();
    }
}
