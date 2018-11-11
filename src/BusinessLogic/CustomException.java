/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class CustomException extends Exception implements Serializable
{
    public CustomException(String message)
    {
        super(message);
    }
}
