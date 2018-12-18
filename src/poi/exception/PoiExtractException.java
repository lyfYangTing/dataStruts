package poi.exception;

/**
 * Created by 18435 on 2018/3/22.
 */
public class PoiExtractException extends RuntimeException{
    public PoiExtractException() {super();}

    public PoiExtractException(String message) {super(message);}

    public PoiExtractException(String message, Throwable e) {super(message, e);}

    public PoiExtractException(Throwable e) {super(e);}
}
