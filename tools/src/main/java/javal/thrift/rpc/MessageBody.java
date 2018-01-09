/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package javal.thrift.rpc;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-10-13")
public class MessageBody implements org.apache.thrift.TBase<MessageBody, MessageBody._Fields>, java.io.Serializable, Cloneable, Comparable<MessageBody> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MessageBody");

  private static final org.apache.thrift.protocol.TField REQUEST_FIELD_DESC = new org.apache.thrift.protocol.TField("request", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField RESPONSE_FIELD_DESC = new org.apache.thrift.protocol.TField("response", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new MessageBodyStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new MessageBodyTupleSchemeFactory();

  public String request; // required
  public String response; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    REQUEST((short)1, "request"),
    RESPONSE((short)2, "response");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // REQUEST
          return REQUEST;
        case 2: // RESPONSE
          return RESPONSE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.REQUEST, new org.apache.thrift.meta_data.FieldMetaData("request", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.RESPONSE, new org.apache.thrift.meta_data.FieldMetaData("response", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MessageBody.class, metaDataMap);
  }

  public MessageBody() {
  }

  public MessageBody(
    String request,
    String response)
  {
    this();
    this.request = request;
    this.response = response;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MessageBody(MessageBody other) {
    if (other.isSetRequest()) {
      this.request = other.request;
    }
    if (other.isSetResponse()) {
      this.response = other.response;
    }
  }

  public MessageBody deepCopy() {
    return new MessageBody(this);
  }

  @Override
  public void clear() {
    this.request = null;
    this.response = null;
  }

  public String getRequest() {
    return this.request;
  }

  public MessageBody setRequest(String request) {
    this.request = request;
    return this;
  }

  public void unsetRequest() {
    this.request = null;
  }

  /** Returns true if field request is set (has been assigned a value) and false otherwise */
  public boolean isSetRequest() {
    return this.request != null;
  }

  public void setRequestIsSet(boolean value) {
    if (!value) {
      this.request = null;
    }
  }

  public String getResponse() {
    return this.response;
  }

  public MessageBody setResponse(String response) {
    this.response = response;
    return this;
  }

  public void unsetResponse() {
    this.response = null;
  }

  /** Returns true if field response is set (has been assigned a value) and false otherwise */
  public boolean isSetResponse() {
    return this.response != null;
  }

  public void setResponseIsSet(boolean value) {
    if (!value) {
      this.response = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case REQUEST:
      if (value == null) {
        unsetRequest();
      } else {
        setRequest((String)value);
      }
      break;

    case RESPONSE:
      if (value == null) {
        unsetResponse();
      } else {
        setResponse((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case REQUEST:
      return getRequest();

    case RESPONSE:
      return getResponse();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case REQUEST:
      return isSetRequest();
    case RESPONSE:
      return isSetResponse();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MessageBody)
      return this.equals((MessageBody)that);
    return false;
  }

  public boolean equals(MessageBody that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_request = true && this.isSetRequest();
    boolean that_present_request = true && that.isSetRequest();
    if (this_present_request || that_present_request) {
      if (!(this_present_request && that_present_request))
        return false;
      if (!this.request.equals(that.request))
        return false;
    }

    boolean this_present_response = true && this.isSetResponse();
    boolean that_present_response = true && that.isSetResponse();
    if (this_present_response || that_present_response) {
      if (!(this_present_response && that_present_response))
        return false;
      if (!this.response.equals(that.response))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetRequest()) ? 131071 : 524287);
    if (isSetRequest())
      hashCode = hashCode * 8191 + request.hashCode();

    hashCode = hashCode * 8191 + ((isSetResponse()) ? 131071 : 524287);
    if (isSetResponse())
      hashCode = hashCode * 8191 + response.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(MessageBody other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetRequest()).compareTo(other.isSetRequest());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRequest()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.request, other.request);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetResponse()).compareTo(other.isSetResponse());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResponse()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.response, other.response);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("MessageBody(");
    boolean first = true;

    sb.append("request:");
    if (this.request == null) {
      sb.append("null");
    } else {
      sb.append(this.request);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("response:");
    if (this.response == null) {
      sb.append("null");
    } else {
      sb.append(this.response);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MessageBodyStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MessageBodyStandardScheme getScheme() {
      return new MessageBodyStandardScheme();
    }
  }

  private static class MessageBodyStandardScheme extends org.apache.thrift.scheme.StandardScheme<MessageBody> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MessageBody struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // REQUEST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.request = iprot.readString();
              struct.setRequestIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // RESPONSE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.response = iprot.readString();
              struct.setResponseIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, MessageBody struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.request != null) {
        oprot.writeFieldBegin(REQUEST_FIELD_DESC);
        oprot.writeString(struct.request);
        oprot.writeFieldEnd();
      }
      if (struct.response != null) {
        oprot.writeFieldBegin(RESPONSE_FIELD_DESC);
        oprot.writeString(struct.response);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MessageBodyTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MessageBodyTupleScheme getScheme() {
      return new MessageBodyTupleScheme();
    }
  }

  private static class MessageBodyTupleScheme extends org.apache.thrift.scheme.TupleScheme<MessageBody> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MessageBody struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetRequest()) {
        optionals.set(0);
      }
      if (struct.isSetResponse()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetRequest()) {
        oprot.writeString(struct.request);
      }
      if (struct.isSetResponse()) {
        oprot.writeString(struct.response);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MessageBody struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.request = iprot.readString();
        struct.setRequestIsSet(true);
      }
      if (incoming.get(1)) {
        struct.response = iprot.readString();
        struct.setResponseIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

