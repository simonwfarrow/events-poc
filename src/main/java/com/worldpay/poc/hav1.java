/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.worldpay.poc;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class hav1 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7867599463776041280L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"hav1\",\"namespace\":\"com.worldpay.poc\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"logicalType\":\"uuid\"},{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"NONE\"},{\"name\":\"payload\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"}},{\"name\":\"category\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"occurredAt\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"version\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<hav1> ENCODER =
      new BinaryMessageEncoder<hav1>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<hav1> DECODER =
      new BinaryMessageDecoder<hav1>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<hav1> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<hav1> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<hav1> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<hav1>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this hav1 to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a hav1 from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a hav1 instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static hav1 fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String id;
   private java.lang.String name;
   private java.util.Map<java.lang.String,java.lang.String> payload;
   private java.lang.String category;
   private java.lang.String occurredAt;
   private int version;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public hav1() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param name The new value for name
   * @param payload The new value for payload
   * @param category The new value for category
   * @param occurredAt The new value for occurredAt
   * @param version The new value for version
   */
  public hav1(java.lang.String id, java.lang.String name, java.util.Map<java.lang.String,java.lang.String> payload, java.lang.String category, java.lang.String occurredAt, java.lang.Integer version) {
    this.id = id;
    this.name = name;
    this.payload = payload;
    this.category = category;
    this.occurredAt = occurredAt;
    this.version = version;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    case 2: return payload;
    case 3: return category;
    case 4: return occurredAt;
    case 5: return version;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = value$ != null ? value$.toString() : null; break;
    case 1: name = value$ != null ? value$.toString() : null; break;
    case 2: payload = (java.util.Map<java.lang.String,java.lang.String>)value$; break;
    case 3: category = value$ != null ? value$.toString() : null; break;
    case 4: occurredAt = value$ != null ? value$.toString() : null; break;
    case 5: version = (java.lang.Integer)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.String getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.String getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.String value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'payload' field.
   * @return The value of the 'payload' field.
   */
  public java.util.Map<java.lang.String,java.lang.String> getPayload() {
    return payload;
  }


  /**
   * Sets the value of the 'payload' field.
   * @param value the value to set.
   */
  public void setPayload(java.util.Map<java.lang.String,java.lang.String> value) {
    this.payload = value;
  }

  /**
   * Gets the value of the 'category' field.
   * @return The value of the 'category' field.
   */
  public java.lang.String getCategory() {
    return category;
  }


  /**
   * Sets the value of the 'category' field.
   * @param value the value to set.
   */
  public void setCategory(java.lang.String value) {
    this.category = value;
  }

  /**
   * Gets the value of the 'occurredAt' field.
   * @return The value of the 'occurredAt' field.
   */
  public java.lang.String getOccurredAt() {
    return occurredAt;
  }


  /**
   * Sets the value of the 'occurredAt' field.
   * @param value the value to set.
   */
  public void setOccurredAt(java.lang.String value) {
    this.occurredAt = value;
  }

  /**
   * Gets the value of the 'version' field.
   * @return The value of the 'version' field.
   */
  public int getVersion() {
    return version;
  }


  /**
   * Sets the value of the 'version' field.
   * @param value the value to set.
   */
  public void setVersion(int value) {
    this.version = value;
  }

  /**
   * Creates a new hav1 RecordBuilder.
   * @return A new hav1 RecordBuilder
   */
  public static com.worldpay.poc.hav1.Builder newBuilder() {
    return new com.worldpay.poc.hav1.Builder();
  }

  /**
   * Creates a new hav1 RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new hav1 RecordBuilder
   */
  public static com.worldpay.poc.hav1.Builder newBuilder(com.worldpay.poc.hav1.Builder other) {
    if (other == null) {
      return new com.worldpay.poc.hav1.Builder();
    } else {
      return new com.worldpay.poc.hav1.Builder(other);
    }
  }

  /**
   * Creates a new hav1 RecordBuilder by copying an existing hav1 instance.
   * @param other The existing instance to copy.
   * @return A new hav1 RecordBuilder
   */
  public static com.worldpay.poc.hav1.Builder newBuilder(com.worldpay.poc.hav1 other) {
    if (other == null) {
      return new com.worldpay.poc.hav1.Builder();
    } else {
      return new com.worldpay.poc.hav1.Builder(other);
    }
  }

  /**
   * RecordBuilder for hav1 instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<hav1>
    implements org.apache.avro.data.RecordBuilder<hav1> {

    private java.lang.String id;
    private java.lang.String name;
    private java.util.Map<java.lang.String,java.lang.String> payload;
    private java.lang.String category;
    private java.lang.String occurredAt;
    private int version;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.worldpay.poc.hav1.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.payload)) {
        this.payload = data().deepCopy(fields()[2].schema(), other.payload);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.category)) {
        this.category = data().deepCopy(fields()[3].schema(), other.category);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.occurredAt)) {
        this.occurredAt = data().deepCopy(fields()[4].schema(), other.occurredAt);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.version)) {
        this.version = data().deepCopy(fields()[5].schema(), other.version);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
    }

    /**
     * Creates a Builder by copying an existing hav1 instance
     * @param other The existing instance to copy.
     */
    private Builder(com.worldpay.poc.hav1 other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.payload)) {
        this.payload = data().deepCopy(fields()[2].schema(), other.payload);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.category)) {
        this.category = data().deepCopy(fields()[3].schema(), other.category);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.occurredAt)) {
        this.occurredAt = data().deepCopy(fields()[4].schema(), other.occurredAt);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.version)) {
        this.version = data().deepCopy(fields()[5].schema(), other.version);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.String getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.worldpay.poc.hav1.Builder setId(java.lang.String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.worldpay.poc.hav1.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.worldpay.poc.hav1.Builder setName(java.lang.String value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.worldpay.poc.hav1.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'payload' field.
      * @return The value.
      */
    public java.util.Map<java.lang.String,java.lang.String> getPayload() {
      return payload;
    }


    /**
      * Sets the value of the 'payload' field.
      * @param value The value of 'payload'.
      * @return This builder.
      */
    public com.worldpay.poc.hav1.Builder setPayload(java.util.Map<java.lang.String,java.lang.String> value) {
      validate(fields()[2], value);
      this.payload = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'payload' field has been set.
      * @return True if the 'payload' field has been set, false otherwise.
      */
    public boolean hasPayload() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'payload' field.
      * @return This builder.
      */
    public com.worldpay.poc.hav1.Builder clearPayload() {
      payload = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'category' field.
      * @return The value.
      */
    public java.lang.String getCategory() {
      return category;
    }


    /**
      * Sets the value of the 'category' field.
      * @param value The value of 'category'.
      * @return This builder.
      */
    public com.worldpay.poc.hav1.Builder setCategory(java.lang.String value) {
      validate(fields()[3], value);
      this.category = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'category' field has been set.
      * @return True if the 'category' field has been set, false otherwise.
      */
    public boolean hasCategory() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'category' field.
      * @return This builder.
      */
    public com.worldpay.poc.hav1.Builder clearCategory() {
      category = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'occurredAt' field.
      * @return The value.
      */
    public java.lang.String getOccurredAt() {
      return occurredAt;
    }


    /**
      * Sets the value of the 'occurredAt' field.
      * @param value The value of 'occurredAt'.
      * @return This builder.
      */
    public com.worldpay.poc.hav1.Builder setOccurredAt(java.lang.String value) {
      validate(fields()[4], value);
      this.occurredAt = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'occurredAt' field has been set.
      * @return True if the 'occurredAt' field has been set, false otherwise.
      */
    public boolean hasOccurredAt() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'occurredAt' field.
      * @return This builder.
      */
    public com.worldpay.poc.hav1.Builder clearOccurredAt() {
      occurredAt = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'version' field.
      * @return The value.
      */
    public int getVersion() {
      return version;
    }


    /**
      * Sets the value of the 'version' field.
      * @param value The value of 'version'.
      * @return This builder.
      */
    public com.worldpay.poc.hav1.Builder setVersion(int value) {
      validate(fields()[5], value);
      this.version = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'version' field has been set.
      * @return True if the 'version' field has been set, false otherwise.
      */
    public boolean hasVersion() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'version' field.
      * @return This builder.
      */
    public com.worldpay.poc.hav1.Builder clearVersion() {
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public hav1 build() {
      try {
        hav1 record = new hav1();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.String) defaultValue(fields()[1]);
        record.payload = fieldSetFlags()[2] ? this.payload : (java.util.Map<java.lang.String,java.lang.String>) defaultValue(fields()[2]);
        record.category = fieldSetFlags()[3] ? this.category : (java.lang.String) defaultValue(fields()[3]);
        record.occurredAt = fieldSetFlags()[4] ? this.occurredAt : (java.lang.String) defaultValue(fields()[4]);
        record.version = fieldSetFlags()[5] ? this.version : (java.lang.Integer) defaultValue(fields()[5]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<hav1>
    WRITER$ = (org.apache.avro.io.DatumWriter<hav1>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<hav1>
    READER$ = (org.apache.avro.io.DatumReader<hav1>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.id);

    out.writeString(this.name);

    long size0 = this.payload.size();
    out.writeMapStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (java.util.Map.Entry<java.lang.String, java.lang.String> e0: this.payload.entrySet()) {
      actualSize0++;
      out.startItem();
      out.writeString(e0.getKey());
      java.lang.String v0 = e0.getValue();
      out.writeString(v0);
    }
    out.writeMapEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Map-size written was " + size0 + ", but element count was " + actualSize0 + ".");

    out.writeString(this.category);

    out.writeString(this.occurredAt);

    out.writeInt(this.version);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readString();

      this.name = in.readString();

      long size0 = in.readMapStart();
      java.util.Map<java.lang.String,java.lang.String> m0 = this.payload; // Need fresh name due to limitation of macro system
      if (m0 == null) {
        m0 = new java.util.HashMap<java.lang.String,java.lang.String>((int)size0);
        this.payload = m0;
      } else m0.clear();
      for ( ; 0 < size0; size0 = in.mapNext()) {
        for ( ; size0 != 0; size0--) {
          java.lang.String k0 = null;
          k0 = in.readString();
          java.lang.String v0 = null;
          v0 = in.readString();
          m0.put(k0, v0);
        }
      }

      this.category = in.readString();

      this.occurredAt = in.readString();

      this.version = in.readInt();

    } else {
      for (int i = 0; i < 6; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readString();
          break;

        case 1:
          this.name = in.readString();
          break;

        case 2:
          long size0 = in.readMapStart();
          java.util.Map<java.lang.String,java.lang.String> m0 = this.payload; // Need fresh name due to limitation of macro system
          if (m0 == null) {
            m0 = new java.util.HashMap<java.lang.String,java.lang.String>((int)size0);
            this.payload = m0;
          } else m0.clear();
          for ( ; 0 < size0; size0 = in.mapNext()) {
            for ( ; size0 != 0; size0--) {
              java.lang.String k0 = null;
              k0 = in.readString();
              java.lang.String v0 = null;
              v0 = in.readString();
              m0.put(k0, v0);
            }
          }
          break;

        case 3:
          this.category = in.readString();
          break;

        case 4:
          this.occurredAt = in.readString();
          break;

        case 5:
          this.version = in.readInt();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










