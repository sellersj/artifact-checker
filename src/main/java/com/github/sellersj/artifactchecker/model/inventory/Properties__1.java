
package com.github.sellersj.artifactchecker.model.inventory;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mail.smtp.auth",
    "mail.smtp.port",
    "mail.smtp.socketFactory.fallback",
    "mail.smtp.socketFactory.port",
    "mail.smtp.starttls.enable"
})
@Generated("jsonschema2pojo")
public class Properties__1 {

    @JsonProperty("mail.smtp.auth")
    private String mailSmtpAuth;
    @JsonProperty("mail.smtp.port")
    private String mailSmtpPort;
    @JsonProperty("mail.smtp.socketFactory.fallback")
    private String mailSmtpSocketFactoryFallback;
    @JsonProperty("mail.smtp.socketFactory.port")
    private String mailSmtpSocketFactoryPort;
    @JsonProperty("mail.smtp.starttls.enable")
    private String mailSmtpStarttlsEnable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("mail.smtp.auth")
    public String getMailSmtpAuth() {
        return mailSmtpAuth;
    }

    @JsonProperty("mail.smtp.auth")
    public void setMailSmtpAuth(String mailSmtpAuth) {
        this.mailSmtpAuth = mailSmtpAuth;
    }

    @JsonProperty("mail.smtp.port")
    public String getMailSmtpPort() {
        return mailSmtpPort;
    }

    @JsonProperty("mail.smtp.port")
    public void setMailSmtpPort(String mailSmtpPort) {
        this.mailSmtpPort = mailSmtpPort;
    }

    @JsonProperty("mail.smtp.socketFactory.fallback")
    public String getMailSmtpSocketFactoryFallback() {
        return mailSmtpSocketFactoryFallback;
    }

    @JsonProperty("mail.smtp.socketFactory.fallback")
    public void setMailSmtpSocketFactoryFallback(String mailSmtpSocketFactoryFallback) {
        this.mailSmtpSocketFactoryFallback = mailSmtpSocketFactoryFallback;
    }

    @JsonProperty("mail.smtp.socketFactory.port")
    public String getMailSmtpSocketFactoryPort() {
        return mailSmtpSocketFactoryPort;
    }

    @JsonProperty("mail.smtp.socketFactory.port")
    public void setMailSmtpSocketFactoryPort(String mailSmtpSocketFactoryPort) {
        this.mailSmtpSocketFactoryPort = mailSmtpSocketFactoryPort;
    }

    @JsonProperty("mail.smtp.starttls.enable")
    public String getMailSmtpStarttlsEnable() {
        return mailSmtpStarttlsEnable;
    }

    @JsonProperty("mail.smtp.starttls.enable")
    public void setMailSmtpStarttlsEnable(String mailSmtpStarttlsEnable) {
        this.mailSmtpStarttlsEnable = mailSmtpStarttlsEnable;
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
        sb.append(Properties__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("mailSmtpAuth");
        sb.append('=');
        sb.append(((this.mailSmtpAuth == null)?"<null>":this.mailSmtpAuth));
        sb.append(',');
        sb.append("mailSmtpPort");
        sb.append('=');
        sb.append(((this.mailSmtpPort == null)?"<null>":this.mailSmtpPort));
        sb.append(',');
        sb.append("mailSmtpSocketFactoryFallback");
        sb.append('=');
        sb.append(((this.mailSmtpSocketFactoryFallback == null)?"<null>":this.mailSmtpSocketFactoryFallback));
        sb.append(',');
        sb.append("mailSmtpSocketFactoryPort");
        sb.append('=');
        sb.append(((this.mailSmtpSocketFactoryPort == null)?"<null>":this.mailSmtpSocketFactoryPort));
        sb.append(',');
        sb.append("mailSmtpStarttlsEnable");
        sb.append('=');
        sb.append(((this.mailSmtpStarttlsEnable == null)?"<null>":this.mailSmtpStarttlsEnable));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.mailSmtpAuth == null)? 0 :this.mailSmtpAuth.hashCode()));
        result = ((result* 31)+((this.mailSmtpPort == null)? 0 :this.mailSmtpPort.hashCode()));
        result = ((result* 31)+((this.mailSmtpSocketFactoryFallback == null)? 0 :this.mailSmtpSocketFactoryFallback.hashCode()));
        result = ((result* 31)+((this.mailSmtpSocketFactoryPort == null)? 0 :this.mailSmtpSocketFactoryPort.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.mailSmtpStarttlsEnable == null)? 0 :this.mailSmtpStarttlsEnable.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties__1) == false) {
            return false;
        }
        Properties__1 rhs = ((Properties__1) other);
        return (((((((this.mailSmtpAuth == rhs.mailSmtpAuth)||((this.mailSmtpAuth!= null)&&this.mailSmtpAuth.equals(rhs.mailSmtpAuth)))&&((this.mailSmtpPort == rhs.mailSmtpPort)||((this.mailSmtpPort!= null)&&this.mailSmtpPort.equals(rhs.mailSmtpPort))))&&((this.mailSmtpSocketFactoryFallback == rhs.mailSmtpSocketFactoryFallback)||((this.mailSmtpSocketFactoryFallback!= null)&&this.mailSmtpSocketFactoryFallback.equals(rhs.mailSmtpSocketFactoryFallback))))&&((this.mailSmtpSocketFactoryPort == rhs.mailSmtpSocketFactoryPort)||((this.mailSmtpSocketFactoryPort!= null)&&this.mailSmtpSocketFactoryPort.equals(rhs.mailSmtpSocketFactoryPort))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.mailSmtpStarttlsEnable == rhs.mailSmtpStarttlsEnable)||((this.mailSmtpStarttlsEnable!= null)&&this.mailSmtpStarttlsEnable.equals(rhs.mailSmtpStarttlsEnable))));
    }

}
