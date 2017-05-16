/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.syncEngine.integration;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmsuarez
 */
@XmlRootElement( name = "CRMSyncEngineMessage")
public class SyncEngineMessage {
    protected String version = "1.0";
    protected SyncEngineMessageOperation operation = SyncEngineMessageOperation.OPERATION_SERVICE_TEST;
    protected SyncEngineMessageError error = SyncEngineMessageError.ERROR_NO_ERROR;
    protected String errorDescription = "";
    protected String sessionCode = "";
    
    protected List<SyncEngineChange> syncSessionChanges = new ArrayList<>();
    protected List<SyncEngineResult> syncSessionResults = new ArrayList<>();

    @XmlAttribute
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlAttribute
    public SyncEngineMessageOperation getOperation() {
        return operation;
    }

    public void setOperation(SyncEngineMessageOperation operation) {
        this.operation = operation;
    }

    @XmlAttribute
    public SyncEngineMessageError getError() {
        return error;
    }

    public void setError(SyncEngineMessageError error) {
        this.error = error;
    }

    @XmlAttribute
    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @XmlAttribute
    public String getSessionCode() {
        return sessionCode;
    }

    public void setSessionCode(String sessionCode) {
        this.sessionCode = sessionCode;
    }

    @XmlElementWrapper(name="syncSessionChanges")
    @XmlElement(name="syncSessionChange")
    public List<SyncEngineChange> getSyncSessionChanges() {
        return syncSessionChanges;
    }

    public void setSyncSessionChanges(List<SyncEngineChange> syncSessionChanges) {
        this.syncSessionChanges = syncSessionChanges;
    }

    @XmlElementWrapper(name="syncSessionResults")
    @XmlElement(name="syncSessionResult")
    public List<SyncEngineResult> getSyncSessionResults() {
        return syncSessionResults;
    }

    public void setSyncSessionResults(List<SyncEngineResult> syncSessionResults) {
        this.syncSessionResults = syncSessionResults;
    }
    
    
    
    public enum SyncEngineMessageOperation{
        OPERATION_SERVICE_TEST,
        OPERATION_OPEN_SESSION,
        OPERATION_REPLY_OPEN_SESSION,
        OPERATION_EXCHANGE_DATA,
        OPERATION_REPLY_EXCHANGE_DATA,
        OPERATION_EXCHANGE_RESULTS,
        OPERATION_REPLY_EXCHANGE_RESULTS,
        OPERATION_CLOSE_SESSION,
        OPERATION_REPLY_CLOSE_SESSION
    }
    
    public enum SyncEngineMessageError{
        ERROR_NO_ERROR,
        ERROR_MESSAGE_INVALID,
        ERROR_SESSION_ALREADY_OPENED,
        ERROR_SESSION_INVALID
    }
}


