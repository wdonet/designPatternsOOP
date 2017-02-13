package ns.learning.patterns.state.visa.protocol

interface VisaProtocolState {
    void go(InputStream is, OutputStream os, VisaProtocolServer visaProtocolServer)
}
