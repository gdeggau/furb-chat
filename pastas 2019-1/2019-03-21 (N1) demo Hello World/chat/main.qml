import QtQuick 2.9
import QtQuick.Controls 2.2

ApplicationWindow {
    visible: true
    width: 640
    height: 480
    title: qsTr("Scroll")

    Image {
        id: img
        source: "imgs/test.jpeg"
        width: 640
        height: 192
        anchors.top: parent
    }

    ScrollView {
        anchors.fill: parent
        topPadding: 220

        ListView {
            width: parent.width
            model: 20
            delegate: ItemDelegate {
                text: "Item " + (index + 1)
                width: parent.width
            }
        }
    }
}
