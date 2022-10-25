package com.ex.api.requests;

import com.ex.api.methods.DeleteMethod;
import com.ex.api.methods.GetMethod;
import com.ex.api.methods.PostMethod;

public class Request {
    protected PostMethod postMethod = new PostMethod();
    protected GetMethod getMethod = new GetMethod();
    protected DeleteMethod deleteMethod = new DeleteMethod();
}
