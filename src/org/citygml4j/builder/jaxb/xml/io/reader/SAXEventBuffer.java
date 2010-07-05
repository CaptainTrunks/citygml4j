package org.citygml4j.builder.jaxb.xml.io.reader;

import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.Characters;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.EndDocument;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.EndElement;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.EndPrefixMapping;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.Location;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.SAXEvent;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.SAXEvent.EventType;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.StartDocument;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.StartElement;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.StartPrefixMapping;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;
import org.xml.sax.helpers.NamespaceSupport;

public class SAXEventBuffer implements ContentHandler {
	final NamespaceSupport namespaces;
	final boolean trackLocation;

	private final LocatorImpl locator;
	private SAXEvent head;
	private SAXEvent tail;

	private EventType lastElementEvent = EventType.END_ELEMENT;
	private Stack<StartElement> parentStartElements;
	private StartElement lastStartElement;

	public SAXEventBuffer() {
		this(false);
	}

	public SAXEventBuffer(boolean trackLocation) {
		this.trackLocation = trackLocation;
		namespaces = new NamespaceSupport();
		locator = trackLocation ? new LocatorImpl() : null;
		parentStartElements = new Stack<StartElement>();
	}

	public void setDocumentLocator(Locator locator) {
		//
	}

	public void updateLocation(int lineNumber, int columnNumber, String systemId, String publicId) {
		locator.setLineNumber(lineNumber);
		locator.setColumnNumber(columnNumber);
		locator.setSystemId(systemId);
		locator.setPublicId(publicId);
	}

	public void skippedEntity(String name) throws SAXException {
		// we do not record this event
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		if (lastElementEvent == EventType.START_ELEMENT)
			addEvent(new Characters(ch, start, length, getLocation()));
	}

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// we do not record this event
	}

	public void processingInstruction(String target, String data) throws SAXException {
		// we do not record this event
	}

	public void startDocument() throws SAXException {
		addEvent(StartDocument.SINGLETON);
	}

	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		StartElement element = new StartElement(uri, localName, atts, getLocation());		
		if (lastElementEvent == EventType.START_ELEMENT) {
			parentStartElements.push(lastStartElement);
			lastStartElement.setNext(element);
			tail = lastStartElement;
		}

		addEvent(element);
		lastStartElement = element;
		lastElementEvent = EventType.START_ELEMENT;
	}

	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		namespaces.pushContext();
		namespaces.declarePrefix(prefix, uri);		
		addEvent(new StartPrefixMapping(prefix, uri));
	}

	public void endDocument() throws SAXException {
		addEvent(EndDocument.SINGLETON);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (lastElementEvent == EventType.END_ELEMENT)
			parentStartElements.pop();

		addEvent(new EndElement(uri, localName, getLocation()));
		lastElementEvent = EventType.END_ELEMENT;
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		namespaces.popContext();		
		addEvent(new EndPrefixMapping(prefix));
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void clear() {
		head = tail = null;
		namespaces.reset();
	}

	public void addEvent(SAXEvent event) {
		if (!isEmpty()) {
			tail.setNext(event);
			tail = event;
		} else
			head = tail = event;		
	}

	public void append(SAXEventBuffer other) {
		if (other.isEmpty())
			return;

		if (!isEmpty()) {
			addEvent(other.head);
			tail = other.tail;
		} else {
			head = other.head;
			tail = other.tail;
		}
	}

	public SAXEvent getFirstEvent() {
		return head;
	}

	public SAXEvent getFirstEvent(EventType type) {
		if (!isEmpty()) {
			SAXEvent event = head;			
			do {
				if (event.getType() == type)
					return event;
			} while ((event = event.next()) != null);
		}

		return null;
	}

	public void setFirstEvent(SAXEvent event) {
		head = event;
	}

	public SAXEvent getLastEvent() {
		return tail;
	}

	public StartElement getFirstStartElement() {
		return (StartElement)getFirstEvent(EventType.START_ELEMENT);
	}

	public StartElement getLastStartElement() {
		return lastStartElement;
	}

	public StartElement getParentStartElement() {
		return parentStartElements.peek();
	}

	private Location getLocation() {
		return trackLocation ? new Location(
				locator.getLineNumber(), 
				locator.getColumnNumber(),
				locator.getSystemId(),
				locator.getPublicId()) : null;
	}

	private static final class StackItem<T> {
		private final T value;
		private StackItem<T> next;

		StackItem(T value) {
			this.value = value;
		}
	}

	private static final class Stack<T> {
		private StackItem<T> head;

		void push(T item) {
			StackItem<T> tmp = new StackItem<T>(item);
			if (!isEmpty()) {
				tmp.next = head;
				head = tmp;
			}
			else
				head = tmp;
		}

		T pop() {
			if (!isEmpty()) {
				StackItem<T> tmp = head;
				head = head.next;			
				return tmp.value;
			}

			return null;
		}

		T peek() {
			return !isEmpty() ? head.value : null;
		}

		boolean isEmpty() {
			return head == null;
		}
	}

}
