var exec = require('cordova/exec');

exports.coolMethod = function (setting, success, error) {
	var options = {};
    options.setting = setting;
    exec(success, error, 'testios', 'coolMethod', [options]);
};
