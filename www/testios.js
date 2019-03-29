var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    var options = {};
    options.setting = arg0;
    exec(success, error, "testios", "coolMethod", [options]);
};
