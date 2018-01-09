/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package thrift.rpc;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum StatusCode implements org.apache.thrift.TEnum {
  OK(0),
  PARAM_ERROR(-1),
  UNKNOWN_ERROR(-2);

  private final int value;

  private StatusCode(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static StatusCode findByValue(int value) { 
    switch (value) {
      case 0:
        return OK;
      case -1:
        return PARAM_ERROR;
      case -2:
        return UNKNOWN_ERROR;
      default:
        return null;
    }
  }
}
