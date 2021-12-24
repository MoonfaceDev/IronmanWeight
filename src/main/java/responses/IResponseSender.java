package responses;

import requests.IRequest;

public interface IResponseSender {
    void sendResponse(String response, IRequest request);
}
