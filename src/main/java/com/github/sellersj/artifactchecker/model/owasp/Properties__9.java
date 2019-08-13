
package com.github.sellersj.artifactchecker.model.owasp;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"message", "stackTrace", "innerException"})
public class Properties__9 {

    @JsonProperty("message")
    private Message message;

    @JsonProperty("stackTrace")
    private StackTrace stackTrace;

    @JsonProperty("innerException")
    private InnerException innerException;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("message")
    public Message getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(Message message) {
        this.message = message;
    }

    @JsonProperty("stackTrace")
    public StackTrace getStackTrace() {
        return stackTrace;
    }

    @JsonProperty("stackTrace")
    public void setStackTrace(StackTrace stackTrace) {
        this.stackTrace = stackTrace;
    }

    @JsonProperty("innerException")
    public InnerException getInnerException() {
        return innerException;
    }

    @JsonProperty("innerException")
    public void setInnerException(InnerException innerException) {
        this.innerException = innerException;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Properties__9.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
            .append('[');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null) ? "<null>" : this.message));
        sb.append(',');
        sb.append("stackTrace");
        sb.append('=');
        sb.append(((this.stackTrace == null) ? "<null>" : this.stackTrace));
        sb.append(',');
        sb.append("innerException");
        sb.append('=');
        sb.append(((this.innerException == null) ? "<null>" : this.innerException));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.stackTrace == null) ? 0 : this.stackTrace.hashCode()));
        result = ((result * 31) + ((this.innerException == null) ? 0 : this.innerException.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.message == null) ? 0 : this.message.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties__9) == false) {
            return false;
        }
        Properties__9 rhs = ((Properties__9) other);
        return (((((this.stackTrace == rhs.stackTrace)
            || ((this.stackTrace != null) && this.stackTrace.equals(rhs.stackTrace)))
            && ((this.innerException == rhs.innerException)
                || ((this.innerException != null) && this.innerException.equals(rhs.innerException))))
            && ((this.additionalProperties == rhs.additionalProperties)
                || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))))
            && ((this.message == rhs.message) || ((this.message != null) && this.message.equals(rhs.message))));
    }

}
