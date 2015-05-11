package gainmaster.service.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lorre on 5/11/15.
 */

@Controller
public class RevokeTokenController {

    @Autowired
    private DefaultTokenServices defaultTokenServices;

    @RequestMapping(value = "/oauth/revoke", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> create(@RequestParam("token") String value) throws InvalidClientException {
        if(defaultTokenServices.revokeToken(value)){
            return new ResponseEntity<String>(HttpStatus.OK);
        };
        return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

    }
}