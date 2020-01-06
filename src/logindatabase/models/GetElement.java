/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindatabase.models;

/**
 *
 * @author mdami
 */
public class GetElement {

    private String element;
    private int count;
    public GetElement(String  gender, int count) {
        this.element = gender;
        this.count = count;
    }

    public String  getElement() {
        return element;
    }

    public void setElement(String  element) {
        this.element = element;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
