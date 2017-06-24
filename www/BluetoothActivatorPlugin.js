var exec = require('cordova/exec'),
    cordova = require('cordova');

function BluetoothActivatorPlugin() {

}
BluetoothActivatorPlugin.prototype.getWeight = function(item, classname, successCallback, errorCallback) {
    exec(successCallback, errorCallback, "BluetoothActivatorPlugin", "getWeight", []);
};

module.exports = new BluetoothActivatorPlugin();


