/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.util.ArrayList;

/**
 *
 * @author Hendriko
 */
public class Validation
{

    static ArrayList<String> errors = new ArrayList<>();

    // <editor-fold desc="Staff Validation">
    public static void IsValidStaffID(String id)
    {
        if (id.isEmpty())
        {
            errors.add("ID cannot be empty");
        } else if (id.length() != 13)
        {
            errors.add("Length of ID must be 13 characters");
        }

        int count = 0;

        for (int i = 0; i < id.length(); i++)
        {
            if (Character.isLetter(id.charAt(i)))
            {
                count++;
            }
        }

        if (count > 0)
        {
            errors.add("ID cannot contain letters");
        }
    }

    public static void IsValidName(String name)
    {
        if (name.isEmpty())
        {
            errors.add("Name cannot be empty");
        } else if (name.length() > 50)
        {
            errors.add("Maximum length of name is 50 characters");
        }

        int count = 0;

        for (int i = 0; i < name.length(); i++)
        {
            if (Character.isDigit(name.charAt(i)))
            {
                count++;
            }
        }

        if (count > 0)
        {
            errors.add("Name cannot contain numbers");
        }
    }

    public static void IsValidSurname(String surname)
    {
        if (surname.isEmpty())
        {
            errors.add("Surname cannot be empty");
        } else if (surname.length() > 50)
        {
            errors.add("Maximum length of surname is 50 characters");
        }

        int count = 0;

        for (int i = 0; i < surname.length(); i++)
        {
            if (Character.isDigit(surname.charAt(i)))
            {
                count++;
            }
        }

        if (count > 0)
        {
            errors.add("Surname cannot contain numbers");
        }
    }

    public static void IsValidCellNo(String cellNo)
    {
        if (cellNo.isEmpty())
        {
            errors.add("Cell number cannot be empty");
        } else if (cellNo.length() != 10)
        {
            errors.add("Cell number length is invalid");
        }

        int count = 0;

        for (int i = 0; i < cellNo.length(); i++)
        {
            if (Character.isLetter(cellNo.charAt(i)))
            {
                count++;
            }
        }

        if (count > 0)
        {
            errors.add("Cell number cannot contain letters");
        }
    }

    public static void IsValidEmail(String email)
    {
        if (email.isEmpty())
        {
            errors.add("Email cannot be empty");
        } else if (!email.contains("@"))
        {
            errors.add("Email does not contain @ character");
        } else if (!email.contains("."))
        {
            errors.add("Email does not contain . character");
        }
    }

    // </editor-fold>
    
    // <editor-fold desc="Address Validation">
    public static void IsValidCity(String city)
    {
        if (city.isEmpty())
        {
            errors.add("City cannot be empty");
        } else if (city.length() > 50)
        {
            errors.add("Maximum length for city is 50 characters");
        }

        int count = 0;

        for (int i = 0; i < city.length(); i++)
        {
            if (!(Character.isLetter(city.charAt(i))))
            {
                count++;
            }
        }

        if (count > 0)
        {
            errors.add("City can only contain letters");
        }
    }

    public static void IsValidStreet(String street)
    {
        if (street.isEmpty())
        {
            errors.add("Street cannot be empty");
        } else if (street.length() > 50)
        {
            errors.add("Maximum length for street is 50 characters");
        }

        int count = 0;

        for (int i = 0; i < street.length(); i++)
        {
            if (!(Character.isLetter(street.charAt(i))))
            {
                count++;
            }
        }

        if (count > 0)
        {
            errors.add("Street can only contain letters");
        }
    }

    public static void IsValidSuburb(String suburb)
    {
        if (suburb.isEmpty())
        {
            errors.add("Suburb cannot be empty");
        } else if (suburb.length() > 50)
        {
            errors.add("Maximum length for suburb is 50 characters");
        }

        int count = 0;

        for (int i = 0; i < suburb.length(); i++)
        {
            if (!(Character.isLetter(suburb.charAt(i))))
            {
                count++;
            }
        }

        if (count > 0)
        {
            errors.add("Suburb can only contain letters");
        }
    }

    public static void IsValidPort(String port)
    {
        if (port.isEmpty())
        {
            errors.add("Port cannot be empty");
        }
        else if (port.length() != 4)
        {
            errors.add("Port must be 4 characters long");
        }

        int count = 0;

        for (int i = 0; i < port.length(); i++)
        {
            if (!(Character.isDigit(port.charAt(i))))
            {
                count++;
            }
        }

        if (count > 0)
        {
            errors.add("Port can only contain numbers");
        }
    }
    // </editor-fold>
    
    // <editor-fold desc="Login Validation">
    
    public static void IsValidUsername(String username)
    {
        if (username.isEmpty())
        {
            errors.add("Username cannot be empty");
        }
        else if (username.length() > 50)
        {
            errors.add("Maximum length of username is 50 characters");
        }
    }
    
    public static void IsValidPassword(String password)
    {
        if (password.isEmpty())
        {
            errors.add("Password cannot be empty");
        }
        else if (password.length() > 50)
        {
            errors.add("Maximum length of password is 50 characters");
        }
    }
    
    // </editor-fold>

    public static ArrayList<String> GetErrors()
    {
        return errors;
    }

    public static void ClearErrors()
    {
        errors.clear();
    }
}
