package com.udea.testing.program1.statisticsServiceConsumer.model;

import org.springframework.data.annotation.Id;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.3
 */
public class NumberSet {
    @Id
    String uuid;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public void calculateCorrelation() {
        this.calculateBeta();
        Node node = this.getList().getFirst();
        Double sumXY = 0.0;
        Double yY = 0.0;
        Double xX = 0.0;
        Double sumX = 0.0;
        Double sumY = 0.0;
        while (node != null) {
            sumXY = sumXY + node.getX() * node.getY();
            yY = yY + Math.pow(node.getY(), 2.0);
            xX = xX + Math.pow(node.getX(), 2.0);
            sumX = sumX + node.getX();
            sumY = sumY + node.getY();
            node = node.getLink();
        }
        this.setCorrelation((this.getList().getSize() * sumXY - sumX * sumY) / (Math.sqrt((this.getList().getSize() * xX - Math.pow(sumX, 2.0)) * (this.getList().getSize() * yY - Math.pow(sumY, 2.0)))));
    }

    public void calculateBeta() {
        this.calculateMean();
        Node node = this.getList().getFirst();
        Double sumXY = 0.0;
        Double xX = 0.0;
        while (node != null) {
            sumXY = sumXY + node.getX() * node.getY();
            xX = xX + Math.pow(node.getX(), 2.0);
            node = node.getLink();
        }
        this.setBeta1(sumXY - this.getList().getSize() * this.getMeanX() * this.getMeanY() / (xX - this.getList().getSize() * Math.pow(this.getMeanX(), 2.0)));
        this.setBeta0(beta0 = this.getMeanY() - this.getBeta1() * this.getMeanX());
    }
}
